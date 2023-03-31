package com.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;

public class Length implements ActionListener{
    private String[] convList = {"Kilometers" , "Meters", "Centimeters", "Millimeters", "Miles", "Yards", "Feet", "Inches", "Nautical Miles"};
    private JPanel   lengthPanel = new JPanel();
    private JComboBox FirstLengthCombo = new JComboBox(convList);
    private JComboBox SecondLengthCombo = new JComboBox(convList);
    private JLabel toLabel = new JLabel("to:");
    private JTextField from = new JTextField();
    private JLabel answerLabel = new JLabel("Answer Here",SwingConstants.CENTER);
    private double currentInput = 0;
    private double[] selectedDropIndex = new double[2];
    private JLabel unitsLabel = new JLabel("Units", SwingConstants.CENTER);
    private JButton convertButton = new JButton("Convert");
    private int index = 0;

    public Length(){
        runTemperPanel();
    }
    private void runTemperPanel(){
        lengthPanel.setLayout(null);
        lengthPanel.setVisible(true);

        FirstLengthCombo.setSelectedIndex(-1);
        SecondLengthCombo.setSelectedIndex(-1);

        unitsLabel.setBounds(395,140,150,50);
        unitsLabel.setOpaque(true);
        unitsLabel.setBackground(Color.GRAY);
        unitsLabel.setForeground(Color.WHITE);
        lengthPanel.add(unitsLabel);

        lengthPanel.add(FirstLengthCombo);
        FirstLengthCombo.setBounds(50,50,150,50);
        lengthPanel.add(SecondLengthCombo);
        SecondLengthCombo.setBounds(240,50,150,50);
        lengthPanel.add(toLabel);
        toLabel.setBounds(210,50,20,50);

        lengthPanel.add(from);
        from.setBounds(50,140,150,50);
        lengthPanel.add(answerLabel);
        answerLabel.setOpaque(true);
        answerLabel.setBackground(Color.GRAY);
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(240, 140, 150,50);

        lengthPanel.add(convertButton);
        convertButton.setOpaque(true);
        convertButton.setForeground(Color.WHITE);
        convertButton.setBackground(Color.BLACK);
        convertButton.setBounds(260, 220, 100,30);

        FirstLengthCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox test = (JComboBox)e.getSource();
                String item = (String) test.getSelectedItem();
                int index = test.getSelectedIndex();
                selectedDropIndex[0] = index;
            }
        });

        SecondLengthCombo.addActionListener(new ActionListener() {
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
                lengthPanel.remove(answerLabel);
                analyzeInput();

            }
        });

    }
    private void analyzeInput()  {
        if (selectedDropIndex[0] == 0) {
            if (selectedDropIndex[1] == 0) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(KiloToMeter(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(KiloToMeter(currentInput)*100);
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(KiloToMeter(currentInput)*1000); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(KiloToMile(currentInput));
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(KiloToYard(currentInput));
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(KiloToYard(currentInput)*3); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(KiloToYard(currentInput)*36); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(KiloToNaut(currentInput));
            }
        } //checked

        if (selectedDropIndex[0] == 1) {
            if (selectedDropIndex[1] == 1) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(MeterToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(MeterToCenti(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(MeterToMilli(currentInput)); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(MeterToMile(currentInput));
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(MeterToYard(currentInput));
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(MeterToYard(currentInput)*3); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(MeterToYard(currentInput)*36); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(MeterToNaut(currentInput));
            }
        }  //checked

        if (selectedDropIndex[0] == 2) {
            if (selectedDropIndex[1] == 2) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(MeterToKilo(currentInput)/100);
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(MeterToCenti(currentInput)/100);
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(MeterToMilli(currentInput)/100); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(MeterToMile(currentInput)/100);
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(MeterToYard(currentInput)/100);
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(MeterToYard(currentInput)/3/100); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(MeterToYard(currentInput)/36/100); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(MeterToNaut(currentInput)/100);
            }
        } // checked

        if (selectedDropIndex[0] == 3) {
            if (selectedDropIndex[1] == 3) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(MeterToKilo(currentInput)/1000);
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(MeterToCenti(currentInput)/1000);
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(MeterToMilli(currentInput)/1000); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(MeterToMile(currentInput)/1000);
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(MeterToYard(currentInput)/1000);
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(MeterToYard(currentInput)/3/1000); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(MeterToYard(currentInput)/36/1000); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(MeterToNaut(currentInput)/1000);
            }
        } // checked

        if (selectedDropIndex[0] == 4) {
            if (selectedDropIndex[1] == 4) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(MileToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(MileToKilo(currentInput)*100); //meter
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(MileToKilo(currentInput)*10000); //milli
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(MileToKilo(currentInput)*100000);
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(MileToYard(currentInput));
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(MileToYard(currentInput)*3); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(MileToYard(currentInput)*36); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(MileToNaut(currentInput));
            }
        } //checked

        if (selectedDropIndex[0] == 5) {
            if (selectedDropIndex[1] == 5) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(YardToKilo(currentInput)); //kilo
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(YardToKilo(currentInput)*1000);//meter
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(YardToKilo(currentInput)*10000); //centi
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(YardToKilo(currentInput)*1000000); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(YardToMile(currentInput));
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(YardToFoot(currentInput)); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(YardToInch(currentInput)); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(YardToNaut(currentInput));
            }
        } //checked

        if (selectedDropIndex[0] == 6) {
            if (selectedDropIndex[1] == 6) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(YardToKilo(currentInput)/3); //kilo
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(YardToKilo(currentInput)*1000/3);//meter
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(YardToKilo(currentInput)*100000/3); //centi
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(YardToKilo(currentInput)*1000000/3); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(YardToMile(currentInput)/3);
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(YardToFoot(currentInput)/9); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(YardToInch(currentInput)/3); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(YardToNaut(currentInput)/3);
            }
        } //checked

        if (selectedDropIndex[0] == 7) {
            if (selectedDropIndex[1] == 7) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(YardToKilo(currentInput)/36); //kilo
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(YardToKilo(currentInput)*1000/36);//meter
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(YardToKilo(currentInput)*100000/36); //centi
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(YardToKilo(currentInput)*1000000/36); //milli
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(YardToMile(currentInput)/36);
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(YardToFoot(currentInput)/36/3); //foot
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel((currentInput)/12); //inch
            }
            if (selectedDropIndex[1] == 8) {
                outputLabel(YardToNaut(currentInput)/36);
            }
        } //checked

        if (selectedDropIndex[0] == 8 ) {
            if (selectedDropIndex[1] == 8) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(NautToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(NautToKilo(currentInput)*1000);
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(NautToKilo(currentInput)*100000); //milli
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(NautToKilo(currentInput)*1000000);
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(NautToMile(currentInput));
            }
            if (selectedDropIndex[1] == 5) {
                outputLabel(NautToYard(currentInput)); //yard
            }
            if (selectedDropIndex[1] == 6) {
                outputLabel(NautToYard(currentInput)*3); //foot
            }
            if (selectedDropIndex[1] == 7) {
                outputLabel(NautToYard(currentInput)*36); //inch
            }
        } //checked


    } //manages the computational conversions

    private void outputLabel ( double answer){
            if (answer == -1) {
                answerLabel = new JLabel("Switch Conversion", SwingConstants.CENTER);
                answerLabel.setOpaque(true);
                answerLabel.setBackground(Color.RED);
                answerLabel.setForeground(Color.WHITE);
                lengthPanel.add(answerLabel);
                answerLabel.setBounds(240, 140, 150, 50);
            } else {
                answerLabel = new JLabel(String.valueOf(answer), SwingConstants.CENTER);
                answerLabel.setOpaque(true);
                answerLabel.setBackground(Color.GRAY);
                answerLabel.setForeground(Color.WHITE);
                lengthPanel.add(answerLabel);
                answerLabel.setBounds(240, 140, 150, 50);

                unitsLabel = new JLabel(convList[index],SwingConstants.CENTER);
                unitsLabel.setOpaque(true);
                unitsLabel.setBackground(Color.GRAY);
                unitsLabel.setForeground(Color.WHITE);
                lengthPanel.add(unitsLabel);
                unitsLabel.setBounds(395,140,150,50);
            }
        }//alters the output label

    public JPanel getLengthPanel(){
        return lengthPanel;
    }

    public double KiloToMeter(double kilo){
        return kilo*1000;
    }
    public double KiloToMile(double kilo){
        return kilo/1.609;
    }
    public double KiloToYard(double kilo){
        return kilo*1094;
    }
    public double KiloToNaut(double kilo){
        return kilo/1.852;
    }

    public double MeterToKilo(double meter){
        return meter/1000;
    }
    public double MeterToCenti(double meter){
        return meter*100;
    }
    public double MeterToMilli(double meter){
        return meter*1000;
    }
    public double MeterToMile(double meter){
        return meter/1609;
    }
    public double MeterToYard(double meter){
        return meter*1.094;
    }
    public double MeterToNaut(double meter){
        return meter/1852;
    }

    public double MileToKilo(double mile){
        return mile*1.609;
    }
    public double MileToYard(double mile){
        return mile*1760;
    }
    public double MileToNaut(double mile){
        return mile/1.151;
    }

    public double YardToKilo(double yard){
        return yard/1094;
    }
    public double YardToMile(double yard){
        return yard/1760;
    }
    public double YardToFoot(double yard){
        return yard*3;
    }
    public double YardToInch(double yard){
        return yard*36;
    }
    public double YardToNaut(double yard){
        return yard/2025;
    }

    public double NautToKilo(double Naut){
        return Naut*1.852;
    }
    public double NautToMile(double Naut){
        return Naut*1.151;
    }
    public double NautToYard(double Naut){
        return Naut*2025;
    }




















    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
