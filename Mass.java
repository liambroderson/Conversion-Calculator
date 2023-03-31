package com.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;

public class Mass implements ActionListener{
    private String[] convList = {"Kilograms", "Grams", "Milligrams", "Pounds", "Ounces"};
    private JPanel massPanel = new JPanel();
    private JComboBox FirstMassCombo = new JComboBox(convList);
    private JComboBox SecondMassCombo = new JComboBox(convList);
    private JLabel toLabel = new JLabel("to:");
    private JTextField from = new JTextField();
    private JLabel answerLabel = new JLabel("Answer Here",SwingConstants.CENTER);
    private double currentInput = 0;
    private double[] selectedDropIndex = new double[2];
    private JButton convertButton = new JButton("Convert");
    private JLabel unitsLabel = new JLabel("Units", SwingConstants.CENTER);
    private int index = 0;


    public Mass(){
        runMassPanel();
    }

    private void runMassPanel(){
        massPanel.setLayout(null);
        massPanel.setVisible(true);

        FirstMassCombo.setSelectedIndex(-1);
        SecondMassCombo.setSelectedIndex(-1);

        unitsLabel.setBounds(395,140,150,50);
        unitsLabel.setOpaque(true);
        unitsLabel.setBackground(Color.GRAY);
        unitsLabel.setForeground(Color.WHITE);
        massPanel.add(unitsLabel);

        massPanel.add(FirstMassCombo);
        FirstMassCombo.setBounds(50,50,150,50);
        massPanel.add(SecondMassCombo);
        SecondMassCombo.setBounds(240,50,150,50);
        massPanel.add(toLabel);
        toLabel.setBounds(210,50,20,50);

        massPanel.add(from);
        from.setBounds(50,140,150,50);
        massPanel.add(answerLabel);
        answerLabel.setOpaque(true);
        answerLabel.setBackground(Color.GRAY);
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(240, 140, 150,50);

        massPanel.add(convertButton);
        convertButton.setOpaque(true);
        convertButton.setForeground(Color.WHITE);
        convertButton.setBackground(Color.BLACK);
        convertButton.setBounds(260, 220, 100,30);

        FirstMassCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox test = (JComboBox)e.getSource();
                String item = (String) test.getSelectedItem();
                double index = test.getSelectedIndex();
                selectedDropIndex[0] = index;
            }
        });

        SecondMassCombo.addActionListener(new ActionListener() {
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
                massPanel.remove(answerLabel);
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
                outputLabel(KiloToGram(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(KiloToGram(currentInput)*1000); //milli
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(KiloToPound(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(KiloToPound(currentInput)*16);
            } }
        if (selectedDropIndex[0] == 1) {
            if (selectedDropIndex[1] == 1) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(GramToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(GramToMilli(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(GramToPound(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(GramToOunce(currentInput));
            } }
        if (selectedDropIndex[0] == 2) {
            if (selectedDropIndex[1] == 2) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(MilliToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(MilliToKilo(currentInput)*1000);
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(MilliToPound(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(MilliToOz(currentInput));
            } }
        if (selectedDropIndex[0] == 3) {
            if (selectedDropIndex[1] == 3) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(PoundToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(PoundToGram(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(PoundToMilli(currentInput));
            }
            if (selectedDropIndex[1] == 4) {
                outputLabel(PoundToOz(currentInput));
            } }
        if (selectedDropIndex[0] == 4) {
            if (selectedDropIndex[1] == 4) {
                outputLabel(-1);
            }
            if (selectedDropIndex[1] == 0) {
                outputLabel(OzToKilo(currentInput));
            }
            if (selectedDropIndex[1] == 1) {
                outputLabel(OzToGram(currentInput));
            }
            if (selectedDropIndex[1] == 2) {
                outputLabel(OzToMilli(currentInput));
            }
            if (selectedDropIndex[1] == 3) {
                outputLabel(OzToPound(currentInput));
            } }
    }
    private void outputLabel(double answer){
        if(answer == -1){
            answerLabel = new JLabel("Switch Conversion", SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.RED);
            answerLabel.setForeground(Color.WHITE);
            massPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);
        } else {
            answerLabel = new JLabel(String.valueOf(answer), SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.GRAY);
            answerLabel.setForeground(Color.WHITE);
            massPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);

            unitsLabel = new JLabel(convList[index],SwingConstants.CENTER);
            unitsLabel.setOpaque(true);
            unitsLabel.setBackground(Color.GRAY);
            unitsLabel.setForeground(Color.WHITE);
            massPanel.add(unitsLabel);
            unitsLabel.setBounds(395,140,150,50);
        }
    }
    public JPanel getMassPanel(){
        return massPanel;
    }

    //Kilogram to x
    public double KiloToGram(double kilo){
        return kilo*1000;
    }
    public double KiloToPound(double kilo){
        return kilo*2.205;
    }

    //Gram to x
    public double GramToKilo(double gram){
        return gram/1000;
    }
    public double GramToMilli(double gram){
        return gram*1000;
    }
    public double GramToPound(double gram){
        return gram/453.6;
    }
    public double GramToOunce(double gram){
        return gram/28.35;
    }

    //Milligram to x
    public double MilliToKilo(double Milli){
        return Milli/1000000;
    } // to gram is kilo*1000
    public double MilliToPound(double Milli){
        return Milli/453600;
    }
    public double MilliToOz(double Milli){
        return Milli/28350;
    }

    //Pound to X
    public double PoundToKilo(double lb){
        return lb/2.205;
    }
    public double PoundToGram(double lb){
        return lb*453.6;
    }
    public double PoundToMilli(double lb){
        return lb*435600;
    }
    public double PoundToOz(double lb){
        return lb*16;
    }

    //Ounce to x
    public double OzToKilo(double Knot){
        return Knot/35.274;
    }
    public double OzToGram(double Knot){
        return Knot*28.35;
    }
    public double OzToMilli(double Knot){
        return Knot*28350;
    }
    public double OzToPound(double Knot){
        return Knot/16;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
