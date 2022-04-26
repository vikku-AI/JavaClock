package com.pratice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame
{
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("", Font.BOLD, 35);

    MyWindow()
    {
        super.setTitle("My Clock");
        super.setSize(400, 400);
        super.setLocation(300, 50);
        this.createGui();
        this.startClock();
        super.setVisible(true);

    }

    public void createGui()
    {

        //Gui
        heading  = new JLabel("MyClock");
        clockLabel = new JLabel("clock");

        // Set FOnt for the clock and heading
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }

    public void startClock()
    {
        // Without using Thread
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String dateTIme= new Date().toString();
////                String dateTIme = new Date().toLocaleString();
//                Date d = new Date();
//                SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss : a");
//                String dateTIme = sfd.format(d);
//                clockLabel.setText(dateTIme);
//            }
//        });
//        timer.start();

        // Using Thread clock
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss : a");
                        String dateTIme = sfd.format(d);
                        clockLabel.setText(dateTIme);

                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }


}
