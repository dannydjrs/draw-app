import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window extends JFrame {
    public Draw panel;
    private Buttons black;
    private Buttons red;
    private Buttons green;
    private Buttons blue;
    private Buttons yellow;
    private Buttons white;
    private Buttons magenta;
    private Buttons orange;
    private Buttons pink;
    private Buttons grey;
    private Buttons cyan;

    private Buttons chooser;
    public OptionsPanel optionpanel;
    private Options undo;
    private ButtonPanel bpanel;
    private Slider slider;

    public static int WIDTH = 1300;
    public static int HEIGHT = 700;

    private Draw2 draw;

    public Window() {
        super("Draw");
        setSize(WIDTH, HEIGHT);
        this.panel = new Draw();
        this.panel.setBackground(Color.WHITE);
        this.bpanel = new ButtonPanel();
        this.optionpanel = new OptionsPanel();
        this.slider = new Slider();
        SHandler sHandler = new SHandler();
        this.slider.addChangeListener(sHandler);
        this.slider.setSize(WIDTH * 3 / 5, HEIGHT * 1 / 5);
        this.black = new Buttons("    Black    ");
        this.black.setColor(Color.BLACK);
        this.red = new Buttons("     Red     ");
        this.red.setColor(Color.RED);
        this.green = new Buttons("    Green    ");
        this.green.setColor(Color.GREEN);
        this.blue = new Buttons("     Blue    ");
        this.blue.setColor(Color.BLUE);
        this.yellow = new Buttons("   Yellow    ");
        this.yellow.setColor(Color.YELLOW);
        this.magenta = new Buttons("   Magenta  ");
        this.magenta.setColor(Color.MAGENTA);
        this.white = new Buttons("    White    ");
        this.white.setColor(Color.WHITE);
        this.orange = new Buttons("    Orange   ");
        this.orange.setColor(Color.ORANGE);
        this.pink = new Buttons("     Pink     ");
        this.pink.setColor(Color.PINK);
        this.grey = new Buttons("     Grey     ");
        this.grey.setColor(Color.GRAY);
        this.cyan = new Buttons("     Cyan     ");
        this.cyan.setColor(Color.CYAN);
        this.chooser = new Buttons("   Choose    ");
        this.undo = new Options("     Undo     ");
        ButHandler butHandler = new ButHandler();
        this.black.addActionListener(butHandler);
        this.red.addActionListener(butHandler);
        this.green.addActionListener(butHandler);
        this.blue.addActionListener(butHandler);
        this.yellow.addActionListener(butHandler);
        this.white.addActionListener(butHandler);
        this.magenta.addActionListener(butHandler);
        this.orange.addActionListener(butHandler);
        this.pink.addActionListener(butHandler);
        this.grey.addActionListener(butHandler);
        this.cyan.addActionListener(butHandler);
        this.chooser.addActionListener(butHandler);
        this.undo.addActionListener(butHandler);
        Handler handler = new Handler();
        this.panel.addMouseListener(handler);
        this.panel.addMouseMotionListener(handler);
        add(this.panel, "Center");
        this.bpanel.add(this.black);
        this.bpanel.add(this.white);
        this.bpanel.add(this.red);
        this.bpanel.add(this.green);
        this.bpanel.add(this.blue);
        this.bpanel.add(this.yellow);
        this.bpanel.add(this.orange);
        this.bpanel.add(this.pink);
        this.bpanel.add(this.magenta);
        this.bpanel.add(this.cyan);
        this.bpanel.add(this.grey);
        this.bpanel.add(this.chooser);
        this.optionpanel.add(this.undo);
        add(this.bpanel, "West");
        add(this.optionpanel, "East");
        add(this.slider, "South");
    }

    private class Handler implements MouseListener, MouseMotionListener {
        private Handler() {}

        public void mouseClicked(MouseEvent param1MouseEvent) {
            Window.this.panel.addValue(param1MouseEvent.getX(), param1MouseEvent.getY());
        }

        public void mouseReleased(MouseEvent param1MouseEvent) {
            Window.this.panel.clicked = false;
        }

        public void mousePressed(MouseEvent param1MouseEvent) {
            Window.this.panel.clicked = true;
        }

        public void mouseExited(MouseEvent param1MouseEvent) {
            Window.this.panel.inside = false;
        }

        public void mouseEntered(MouseEvent param1MouseEvent) {
            Window.this.panel.inside = true;
        }

        public void mouseDragged(MouseEvent param1MouseEvent) {
            if (Window.this.panel.clicked && Window.this.panel.inside) {
                Window.this.panel.addValue(param1MouseEvent.getX(), param1MouseEvent.getY());
                Window.this.panel.repaint();
            }
        }

        public void mouseMoved(MouseEvent param1MouseEvent) {}
    }

    private class ButHandler implements ActionListener {
        private Color color;

        private ButHandler() {}

        public void actionPerformed(ActionEvent param1ActionEvent) {
            Draw.color = Color.BLACK;
            if (param1ActionEvent.getSource() == Window.this.black)
                this.color = Window.this.black.getColor();
            if (param1ActionEvent.getSource() == Window.this.red)
                this.color = Window.this.red.getColor();
            if (param1ActionEvent.getSource() == Window.this.green)
                this.color = Window.this.green.getColor();
            if (param1ActionEvent.getSource() == Window.this.blue)
                this.color = Window.this.blue.getColor();
            if (param1ActionEvent.getSource() == Window.this.white)
                this.color = Window.this.white.getColor();
            if (param1ActionEvent.getSource() == Window.this.yellow)
                this.color = Window.this.yellow.getColor();
            if (param1ActionEvent.getSource() == Window.this.magenta)
                this.color = Window.this.magenta.getColor();
            if (param1ActionEvent.getSource() == Window.this.orange)
                this.color = Window.this.orange.getColor();
            if (param1ActionEvent.getSource() == Window.this.pink)
                this.color = Window.this.pink.getColor();
            if (param1ActionEvent.getSource() == Window.this.grey)
                this.color = Window.this.grey.getColor();
            if (param1ActionEvent.getSource() == Window.this.cyan)
                this.color = Window.this.cyan.getColor();
            if (param1ActionEvent.getSource() == Window.this.chooser)
                this.color = JColorChooser.showDialog(null, "Pick your colour", Color.BLACK);

            Draw.color = this.color;

            if (param1ActionEvent.getSource() == Window.this.undo)
                Window.this.panel.Undo();
            }
        }

    private class SHandler implements ChangeListener {
        private SHandler() {}

        public void stateChanged(ChangeEvent param1ChangeEvent) {
            Window.this.panel.setWidth(Window.this.slider.getValue());
        }
    }
}
