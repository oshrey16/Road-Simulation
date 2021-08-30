package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author  Oshrey Avraham
 * ID:  316188531
 */
public class Builder extends JDialog implements ActionListener {
    private JPanel p1,p2;
    private JButton b1, b2, back_but;
    private RoadSystemPanel rs;
    private JSlider sl_hor;
    private JLabel lbl_hor;

    public Builder(Main parent, RoadSystemPanel pan, String title) {
        super((Main) parent, title, true);
        rs = pan;
        setSize(600, 200);
        setBackground(new Color(100, 230, 255));
        p1 = new JPanel();
        p2 = new JPanel();

        p1.setLayout(new GridLayout(2,1,10,5));
        lbl_hor = new JLabel("Number of vehicles");
        p1.add(lbl_hor);
        sl_hor = new JSlider(0,50);
        sl_hor.setMajorTickSpacing(5);
        sl_hor.setMinorTickSpacing(1);
        sl_hor.setPaintTicks(true);
        sl_hor.setPaintLabels(true);
        p1.add(sl_hor);

        p2.setLayout(new GridLayout(1,2,5,5));
        b1 = new JButton("City Builder");
        b2 = new JButton("Country Builder");
        back_but = new JButton("Back");

        p2.add(b1);
        p2.add(b2);
        p2.add(back_but);
        add("North" , p1);
        add("South" , p2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        back_but.addActionListener(this);
    }

    public void citybuild(){
        rs.createNewRoadSystem(12,sl_hor.getValue(),"city");
    }
    public void countrybuild(){
        rs.createNewRoadSystem(6,sl_hor.getValue(),"country");
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            citybuild();
            setVisible(false);
        }
        else if(e.getSource() == b2) {
            countrybuild();
            setVisible(false);
        }
        else if(e.getSource() == back_but) {
            setVisible(false);
        }
    }
}
