import javax.swing.*;
import java.awt.*;

public class GuiContent extends JPanel {

    public GuiContent(Dimension d){

        this.setPreferredSize(d);
        this.setFocusable(true);
        this.requestFocus();
    }
}
