import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Draw extends JPanel {
    /** Store the input drawing for saving into files */
    public static ArrayList<String> x = new ArrayList<>();
    public static ArrayList<String> y = new ArrayList<>();
    public static ArrayList<String> cols = new ArrayList<>();
    public static ArrayList<String> w = new ArrayList<>();

    /* Color currently being drawn in */
    public static Color color = Color.BLACK;

    /** Current width of drawing brush */
    private int diameter = 30;

    /** Mouse inside window or is currently clicked */
    public boolean inside;
    public boolean clicked;

    protected void paintComponent(Graphics paramGraphics) {
        super.paintComponent(paramGraphics);

        for (int b = 0; b < x.size(); b++) {
            Color tempColor = new Color(
                Integer.parseInt(cols.get(b * 3)),
                Integer.parseInt(cols.get(b * 3 + 1)),
                Integer.parseInt(cols.get(b * 3 + 2))
            );

            paramGraphics.setColor(tempColor);
            paramGraphics.fillOval(
                Integer.parseInt(x.get(b)) - Integer.parseInt(w.get(b)) / 2, // x location
                Integer.parseInt(y.get(b)) - Integer.parseInt(w.get(b)) / 2, // y location
                Integer.parseInt(w.get(b)), // width
                Integer.parseInt(w.get(b)) // height
            );
        }
    }

    public void addValue(int paramInt1, int paramInt2) {
        if (paramInt1 <= 0) {
            frameRepaint();
            return;
        }

        this.clicked = true;

        String str1 = String.valueOf(paramInt1);
        String str2 = String.valueOf(paramInt2);
        String str3 = String.valueOf(this.diameter);

        x.add(str1);
        y.add(str2);
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
        frameRepaint();
    }

    public void frameRepaint() {
        repaint();
    }

    public void setWidth(int paramInt) {
        this.diameter = paramInt;
    }

    public Dimension getPreferredSize() {
        return new Dimension(
            Window.WIDTH * 3 / 5,
            Window.HEIGHT * 4 / 5
        );
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public void Undo() {
        if (x.size() < 1) {
            return;
        }

        this.inside = true;
        this.clicked = true;

        x.remove(x.size() - 1);
        y.remove(y.size() - 1);
        w.remove(w.size() - 1);
        cols.remove(cols.size() - 1); // remove r
        cols.remove(cols.size() - 1); // remove g
        cols.remove(cols.size() - 1); // remove b

        frameRepaint();
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
