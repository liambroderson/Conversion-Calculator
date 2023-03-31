package com.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;

public class Speed implements ActionListener{
    private String[] convList = {"Miles per Hour", "Feet per Second", "Meter per Second", "KM per Hour", "Knot"};
    private JPanel speedPanel = new JPanel();
    private JComboBox FirstSpeedCombo = new JComboBox(convList);
    private JComboBox SecondSpeedCombo = new JComboBox(convList);
    private JLabel toLabel = new JLabel("to:");
    private JTextField from = new JTextField();
    private JLabel answerLabel = new JLabel("Answer Here",SwingConstants.CENTER);
    private double currentInput = 0;
    private double[] selectedDropIndex = new double[2];
    private JButton convertButton = new JButton("Convert");
    private JLabel unitsLabel = new JLabel("Units", SwingConstants.CENTER);
    private int index = 0;


    public Speed(){
        runSpeedPanel();
    }

    private void runSpeedPanel(){
        speedPanel.setLayout(null);
        speedPanel.setVisible(true);

        FirstSpeedCombo.setSelectedIndex(-1);
        SecondSpeedCombo.setSelectedIndex(-1);

        unitsLabel.setBounds(395,140,150,50);
        unitsLabel.setOpaque(true);
        unitsLabel.setBackground(Color.GRAY);
        unitsLabel.setForeground(Color.WHITE);
        speedPanel.add(unitsLabel);

        speedPanel.add(FirstSpeedCombo);
        FirstSpeedCombo.setBounds(50,50,150,50);
        speedPanel.add(SecondSpeedCombo);
        SecondSpeedCombo.setBounds(240,50,150,50);
        speedPanel.add(toLabel);
        toLabel.setBounds(210,50,20,50);

        speedPanel.add(from);
        from.setBounds(50,140,150,50);
        speedPanel.add(answerLabel);
        answerLabel.setOpaque(true);
        answerLabel.setBackground(Color.GRAY);
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(240, 140, 150,50);

        speedPanel.add(convertButton);
        convertButton.setOpaque(true);
        convertButton.setForeground(Color.WHITE);
        convertButton.setBackground(Color.BLACK);
        convertButton.setBounds(260, 220, 100,30);

        FirstSpeedCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox test = (JComboBox)e.getSource();
                String item = (String) test.getSelectedItem();
                double index = test.getSelectedIndex();
                selectedDropIndex[0] = index;
            }
        });

        SecondSpeedCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox test = (JComboBox)e.getSource();
                String item = (String) test.getSelectedItem();
                index = test.getSelectedIndex();
                selectedDropIndex[1] = index;

            }
        });

        from.addFocusListener(new FocusListener() {
            @Override public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                currentInput = Double.parseDouble(from.getText());
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speedPanel.remove(answerLabel);
                speedPanel.remove(unitsLabel);
                analyzeInput();

            }
        });
    }

    private void analyzeInput() {
        if (selectedDropIndex[0] == 0) {
            if (selectedDropIndex[1] == 0) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(mphToFps(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(mphToMps(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(mphTokph(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(mphToKnot(currentInput));
            } }

        if (selectedDropIndex[0] == 1) {
            if (selectedDropIndex[1] == 1) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(fpsToMph(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(fpsToMps(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(fpsToKph(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(fpsToKnot(currentInput));
            } }

        if (selectedDropIndex[0] == 2) {
            if (selectedDropIndex[1] == 2) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(MpsToMph(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(MpsToFps(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(MpsToKph(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(MpsToKnot(currentInput));
            } }

        if (selectedDropIndex[0] == 3) {
            if (selectedDropIndex[1] == 3) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(KphToMph(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(KphToFps(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(KphToMps(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(KphToKnot(currentInput));
            } }

        if (selectedDropIndex[0] == 4) {
            if (selectedDropIndex[1] == 4) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(KnotToMPH(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(KnotToFPS(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(KnotToMPS(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(KnotToKPH(currentInput));
            } }
    }

    private void outputLabel(double answer){
        if(answer == -1){
            answerLabel = new JLabel("Switch Conversion", SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.RED);
            answerLabel.setForeground(Color.WHITE);
            speedPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);

        } else {
            answerLabel = new JLabel(String.valueOf(answer), SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.GRAY);
            answerLabel.setForeground(Color.WHITE);
            speedPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);

            unitsLabel = new JLabel(convList[index],SwingConstants.CENTER);
            unitsLabel.setOpaque(true);
            unitsLabel.setBackground(Color.GRAY);
            unitsLabel.setForeground(Color.WHITE);
            speedPanel.add(unitsLabel);
            unitsLabel.setBounds(395,140,150,50);
        }
    }

    public JPanel getSpeedPanel(){
        return speedPanel;
    }

    //miles per hour to x
    public double mphToFps(double mph){
        return mph*1.46667;
    }
    public double mphToMps(double mph){
        return mph/2.237;
    }
    public double mphTokph(double mph){
        return mph*1.609;
    }
    public double mphToKnot(double mph){
        return mph/1.151;
    }

    //Feet per second to x
    public double fpsToMph(double fps){
        return fps/1.467;
    }
    public double fpsToMps(double fps){
        return fps/3.281;
    }
    public double fpsToKph(double fps){
        return fps*1.097;
    }
    public double fpsToKnot(double fps){
        return fps/1.688;
    }

    //Meters per second to x
    public double MpsToMph(double Mps){
        return Mps*2.237;
    }
    public double MpsToFps(double Mps){
        return Mps*3.281;
    }
    public double MpsToKph(double Mps){
        return Mps*3.6;
    }
    public double MpsToKnot(double Mps){
        return Mps*1.944;
    }

    //Kilo per hour to x
    public double KphToMph(double Kph){
        return Kph/1.609;
    }
    public double KphToFps(double Kph){
        return Kph/1.097;
    }
    public double KphToMps(double Kph){
        return Kph/3.6;
    }
    public double KphToKnot(double Kph){
        return Kph/1.852;
    }

    //knot to x
    public double KnotToMPH(double Knot){
        return Knot*1.151;
    }
    public double KnotToFPS(double Knot){
        return Knot*1.688;
    }
    public double KnotToMPS(double Knot){
        return Knot/1.944;
    }
    public double KnotToKPH(double Knot){
        return Knot*1.852;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
