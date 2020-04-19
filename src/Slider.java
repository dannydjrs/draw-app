import javax.swing.JSlider;

public class Slider extends JSlider {
    public Slider() {
        super(0, 1, 200, 30);
        setMajorTickSpacing(10);
        setPaintTicks(true);
    }
}
