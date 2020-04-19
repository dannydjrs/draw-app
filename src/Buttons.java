import java.awt.Color;
import javax.swing.JButton;

public class Buttons extends JButton {
    private Color color;

    public Buttons(String paramString) {
        super(paramString);
    }

    public void setColor(Color paramColor) {
        this.color = paramColor;
    }

    public Color getColor() {
        return this.color;
    }
}
