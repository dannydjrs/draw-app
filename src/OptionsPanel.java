import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel {
    private JLabel label;

    public OptionsPanel() {
        setBackground(Color.GRAY);
        this.label = new JLabel("OPTIONS");
        this.label.setFont(new Font("Arial", 1, 24));
        add(this.label);
    }

    public Dimension getPreferredSize() {
        return new Dimension(Window.WIDTH * 1 / 8, Window.HEIGHT);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
