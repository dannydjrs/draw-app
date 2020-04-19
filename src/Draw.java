import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Draw extends JPanel {
    public static ArrayList<String> x = new ArrayList<>();
    public static ArrayList<String> y = new ArrayList<>();
    public static ArrayList<String> cols = new ArrayList<>();
    public static ArrayList<String> w = new ArrayList<>();

    public static Color color = Color.BLACK;

    public boolean inside;
    public boolean clicked;

    private int diameter = 30;

    protected void paintComponent(Graphics paramGraphics) {
        super.paintComponent(paramGraphics);
        for (byte b = 0; b < x.size(); b++) {
            Color color = new Color(
                Integer.parseInt(cols.get(b * 3)),
                Integer.parseInt(cols.get(b * 3 + 1)),
                Integer.parseInt(cols.get(b * 3 + 2))
            );
            paramGraphics.setColor(color);
            paramGraphics.fillOval(Integer.parseInt(x.get(b)) -
            Integer.parseInt(w.get(b)) / 2,
            Integer.parseInt(y.get(b)) - Integer.parseInt(w.get(b)) / 2,
            Integer.parseInt(w.get(b)), Integer.parseInt(w.get(b)));
        }
    }

    public void addValue(int paramInt1, int paramInt2) {
        if (paramInt1 > 0) {
            this.clicked = true;
            String str1 = String.valueOf(paramInt1);
            String str2 = String.valueOf(paramInt2);
            x.add(str1);
            y.add(str2);
            String str3 = String.valueOf(this.diameter);
            w.add(str3);
            try {
                cols.add(String.valueOf(color.getRed()));
                cols.add(String.valueOf(color.getGreen()));
                cols.add(String.valueOf(color.getBlue()));
            } catch (Exception exception) {
                color = Color.BLACK;
                cols.add(String.valueOf(color.getRed()));
                cols.add(String.valueOf(color.getGreen()));
                cols.add(String.valueOf(color.getBlue()));
            }
        }
        frameRepaint();
    }

    public void frameRepaint() {
        repaint();
    }

    public void setWidth(int paramInt) {
        this.diameter = paramInt;
    }

    public Dimension getPreferredSize() {
        return new Dimension(Window.WIDTH * 3 / 5, Window.HEIGHT * 4 / 5);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public void Undo() {
        if (x.size() >= 1) {
            this.inside = true;
            this.clicked = true;
            x.remove(x.size() - 1);
            y.remove(y.size() - 1);
            cols.remove(cols.size() - 1);
            cols.remove(cols.size() - 1);
            cols.remove(cols.size() - 1);
            w.remove(w.size() - 1);
            frameRepaint();
        }
    }

    public void truncate(boolean paramBoolean) {
        int i = 0;
        if (paramBoolean)
            i = JOptionPane.showConfirmDialog(this, "Are you sure", "Fill in the blanks", 1);

        if (i == 0 && cols.size() > 0) {
            byte b;
            for (b = 0; b < x.size(); b++) {
                x.removeAll(x);
                y.removeAll(y);
                w.removeAll(w);
            }
            for (b = 0; b < cols.size(); b++)
                cols.removeAll(cols);
        } else if (i == 1 || i == 2) {

        }
        frameRepaint();
    }
}
