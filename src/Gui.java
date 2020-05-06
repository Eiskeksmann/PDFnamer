import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui(String title, Dimension d){

        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new GuiContent(d));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
