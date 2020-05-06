import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GuiContent extends JPanel {

    private GridBagConstraints gbc;
    private JPanel pan_top, pan_mid, pan_bot;
    private List lst_w, lst_r, lst_log;
    private Button cmd_start, cmd_path;
    private TextField txt_path;
    private Label lbl_w, lbl_r;

    public GuiContent(Dimension d){

        this.setPreferredSize(d);
        this.setFocusable(true);
        this.requestFocus();
        initLayout();
        initComponents();
        setLayout();
    }
    private void initLayout(){

        this.setBorder(new LineBorder(Color.BLACK,2));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
    }
    private void initComponents(){

        this.pan_top = new JPanel();
        runPanelConfig(pan_top);
        this.pan_mid = new JPanel();
        runPanelConfig(pan_mid);
        this.pan_bot = new JPanel();
        runPanelConfig(pan_bot);

        this.lst_w = new List();
        runListConfig(lst_w);
        this.lst_r = new List();
        runListConfig(lst_r);
        this.lst_log = new List();
        //runListConfig(lst_log);

        this.cmd_start = new Button("START");
        runButtonConfig(cmd_start);
        this.cmd_path = new Button("PATH");
        runButtonConfig(cmd_path);

        this.txt_path = new TextField();

        this.lbl_r = new Label("RIGHT");
        this.lbl_w = new Label("WRONG");
    }
    private void runListConfig(List lst){
        lst.setSize(new Dimension(100,1));
    }
    private void runButtonConfig(Button cmd){
        cmd.setBackground(Color.WHITE);
        cmd.setForeground(Color.BLACK);
    }
    private void runPanelConfig(JPanel pan){

        pan.setLayout(new GridBagLayout());
        pan.setBorder(new LineBorder(Color.BLACK, 2));
        pan.setBackground(Color.WHITE);
    }
    private void setLayout(){

        gbc.weightx = 1.0;
        gbc.weighty = 0.33;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.gridheight = 1;
        //gbc.gridwidth = 2;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(pan_top, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(pan_mid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(pan_bot, gbc);

        //Configure Pan_Top
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.gridheight = 1;
        //gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pan_top.add(txt_path, gbc);

        gbc.weightx = 0.2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pan_top.add(cmd_path, gbc);


        //Configure Pan_Mid
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pan_mid.add(lbl_w, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        pan_mid.add(lbl_r, gbc);

        gbc.weighty = 0.9;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pan_mid.add(lst_w, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        pan_mid.add(lst_r, gbc);

        //Configure Pan_Bot
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pan_bot.add(lst_log, gbc);


        gbc.weightx = 0.2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pan_bot.add(cmd_start, gbc);
    }
}
