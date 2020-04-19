import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

public class Main {
    public static boolean fullscreen;

    public static void main(String[] paramArrayOfString) {
        fullscreen = false;
        final Window window = new Window();

        /* Save options */
        Options options1 = new Options("    Save    ");
        window.optionpanel.add(options1);
        options1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
                Files files = new Files();
                String str = JOptionPane.showInputDialog(window, "What do you want to call it?");
                if (str != null)
                    files.saveFile(str);
                }
        });

        /* Clear options */
        Options options2 = new Options("   Clear   ");
        window.optionpanel.add(options2);
        options2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
                window.panel.truncate(true);
            }
        });

        /* Open file options */
        Options options3 = new Options("    Open    ");
        window.optionpanel.add(options3);
        options3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
                Files files = new Files();
                String str = JOptionPane.showInputDialog(window, "What is it called?");

                if (str == null) {
                    return;
                }

                String str1 = str + ".txt";
                File file = new File(str1);

                if (file.exists()) {
                    int i = JOptionPane.showConfirmDialog(window, "Are you sure?");

                    if (i == 0) {
                        window.panel.truncate(false);
                        window.panel.inside = true;
                        window.panel.clicked = true;
                        files.openFile(str);
                        window.panel.addValue(-1, -1);
                    }
                } else {
                    JOptionPane.showMessageDialog(window, "This file does not exist");
                }
            }
        });
        Options options4 = new Options("TOGGLE SCREEN");
        window.optionpanel.add(options4);
        options4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent param1ActionEvent) {
                if (Main.fullscreen) {
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getFullScreenWindow().dispose();
                    window.setVisible(true);
                    Main.fullscreen = false;
                } else {
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(window);
                    Main.fullscreen = true;
                }
            }
        });
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setVisible(true);
    }
}
