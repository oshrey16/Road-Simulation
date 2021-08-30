package lawNorder;

import components.Road;
import components.Vehicle;

import javax.swing.*;
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Moked {
    public static int reportscounter = 0;           //total reports include the history
    public static int verreportscounter = 0;        //have to be equal to reports counter to close the program
    private static FileWriter myWriter;

    public static void refreshcounter(){
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("reportline.txt"));
            reportscounter = Integer.parseInt(myReader.readLine());
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void updatecounter() {
        try {
            myWriter = new FileWriter("reportline.txt");
            myWriter.write(String.valueOf(reportscounter));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void writeReport(Vehicle v) {
        reportscounter++;
        Date time = new java.util.Date(System.currentTimeMillis());
        String sdf = new SimpleDateFormat("HH:mm:ss").format(time);
        String sdf1 = new SimpleDateFormat("dd/MM/yyyy").format(time);
        try {
            myWriter = new FileWriter("reports.txt", true);
            //myWriter.write("Report number " + reportscounter + "; Report Date: " + sdf1 + "; Report Time: " + sdf + "; Vehicle ID:" + v.getID() + ";" + "\n");
            myWriter.write(reportscounter + ";" + sdf1 + ";" + sdf + ";" + v.getID() + ";" + v.getSpeed() + ";" + ((Road)v.getCurrentRoutePart()).getMaxSpeed() + ";" + false + "\n");
            myWriter.close();
            updatecounter();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addVerreportscounter(){
        verreportscounter++;
    }

    public static void refreshVerreport() {
        BufferedReader myReader;
        String line;
        int k;
        try {
            myReader = new BufferedReader(new FileReader("reports.txt"));
            line = myReader.readLine();
            for (int i = 0; i < Moked.reportscounter; i++) {
                k = 0;
                for (String s : line.split(";")) {      //read line words
                    if (k == 6) {
                        if (Boolean.parseBoolean(s.trim())) {
                            addVerreportscounter();
                        }
                    }
                    k++;
                }
                line = myReader.readLine();     //read new line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}