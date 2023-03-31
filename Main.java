package com.test;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    static JFrame Frame;
    static JTabbedPane Tab;
    static JPanel welcomePanel = new JPanel();
    static JPanel lengthPanel= new JPanel();
    static JPanel temperPanel= new JPanel();

    static BufferedImage welcomeImage;
    static JLabel welcomePicLabel;
    static Image dimg;

    public static void main(String[] args) {
        runGUI();
    }
    public static void runGUI() {
        Temperature t = new Temperature();
      //  History h = new History();
        Speed s = new Speed();
        Length l = new Length();
        Mass m = new Mass();
        makeImages();

        Tab = new JTabbedPane();
        Tab.add("Welcome", welcomePanel);
        Tab.add("Speed", s.getSpeedPanel());
        Tab.add("Length", l.getLengthPanel());
        Tab.add("Mass", m.getMassPanel());
        Tab.add("Temperature", t.getTemperPanel());
        //Tab.add("History", h.getHistoryPanel());

        Frame = new JFrame();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Conversion Calculator");
        Frame.pack();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        Frame.setSize(550, 350);
        Frame.add(Tab, BorderLayout.CENTER);

        JLabel welcomeLabel = new JLabel("Welcome! For questions or bug reports please email liamfbroderson@gmail.com");
        welcomePanel.add(welcomeLabel);
        welcomeLabel.setBounds(10,200,220,60);
        welcomePanel.add(welcomePicLabel);
        welcomePicLabel.setBounds(10, 5, 340, 200);
    }
    public static void makeImages(){
        try {
            //welcome logo / picture
            welcomeImage = ImageIO.read(new File("C:\\Users\\Liam Ballz\\IdeaProjects\\Conversion Calculator\\src\\com\\test\\CC logo.png"));
            dimg = welcomeImage.getScaledInstance(450,120,Image.SCALE_SMOOTH);
            welcomePicLabel = new JLabel(new ImageIcon(dimg));

        } catch (IOException e) {
            e.printStackTrace();}}
}
