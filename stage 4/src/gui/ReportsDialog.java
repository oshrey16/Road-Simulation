package gui;

import lawNorder.Moked;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ReportsDialog extends JDialog implements ActionListener {
    private JPanel p1;
    private JScrollPane scrollPane;
    private static BufferedReader myReader;
    private int reports;
    private JButton ok_but;
    private Object [][]data;
    private static FileWriter myWriter;
    private DefaultTableModel model;
    private final String [] columnNames = {"Report #", "Date", "Time", "Vehicle ID","Vehicle Speed", " Road Speed", "Reported"};

    public ReportsDialog(Main parent, RoadSystemPanel pan, String title) {
        super((Main) parent, title, true);
        setSize(600,600);
        setBackground(new Color(100,230,255));
        p1 = new JPanel();

     /*   try {
            myReader = new BufferedReader(new FileReader("reportline.txt"));
            reports= Integer.parseInt(myReader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        reports = Moked.reportscounter;
        data = new Object[reports][columnNames.length];
        String line;
        try {
            myReader = new BufferedReader(new FileReader("reports.txt"));

            line = myReader.readLine();
            int i =0;
            int k;
            while(line != null) {
                k=0;
                for(String s : line.split(";")){
                    if(k==6){
                        data[i][k] = Boolean.parseBoolean(s.trim());
                    }
                    else {
                        data[i][k] = s.trim();
                    }
                    k++;
                }
                i++;
                line = myReader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return column == 6;
            }
        };

        table.setModel(model);
        scrollPane = new JScrollPane(table);
        add( scrollPane, BorderLayout.CENTER );
        ok_but = new JButton("Save");
        ok_but.addActionListener(this);
        p1.add(ok_but);
        add("South", p1);
    }

    public void save_report(){
        Moked.verreportscounter=0;
        //Clean TXT file
        try {
            myWriter = new FileWriter("reports.txt");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Fill TXT file
        String line;
        Boolean boolval;
        for(int i=0;i<Moked.reportscounter;i++){
            boolval = (Boolean) model.getValueAt(i,6);
            if(boolval==true){
                Moked.addVerreportscounter();       //decrease number of opened reports to close the program
            }
            line= data[i][0] + ";" + data[i][1] + ";" +data[i][2] + ";" +data[i][3] + ";" +data[i][4] + ";" +data[i][5] + ";" + boolval + "\n";
            try{
                myWriter = new FileWriter("reports.txt", true);
                myWriter.write(line);
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this,"Save successed!");
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok_but)
            save_report();
    }
}
