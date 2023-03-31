package com.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;

public class Temperature implements ActionListener{
    private String[] convList = {"Fahrenheit", "Celsius", "Kelvin"};
    private JPanel temperPanel = new JPanel();
    private JComboBox FirstTemperCombo = new JComboBox(convList);
    private JComboBox SecondTemperCombo = new JComboBox(convList);
    private JLabel toLabel = new JLabel("to:");
    private JTextField from = new JTextField();
    private JLabel answerLabel = new JLabel("Answer Here",SwingConstants.CENTER);
    private double currentInput = 0;
    private double[] selectedDropIndex = new double[2];
    private JLabel unitsLabel = new JLabel("Units", SwingConstants.CENTER);
    private int index = 0;
    private JButton convertButton = new JButton("Convert");

    public Temperature(){
        runTemperPanel();
    }

    private void runTemperPanel(){
        temperPanel.setLayout(null);
        temperPanel.setVisible(true);

        FirstTemperCombo.setSelectedIndex(-1);
        SecondTemperCombo.setSelectedIndex(-1);

        unitsLabel.setBounds(395,140,150,50);
        unitsLabel.setOpaque(true);
        unitsLabel.setBackground(Color.GRAY);
        unitsLabel.setForeground(Color.WHITE);
        temperPanel.add(unitsLabel);

        temperPanel.add(FirstTemperCombo);
        FirstTemperCombo.setBounds(50,50,150,50);
        temperPanel.add(SecondTemperCombo);
        SecondTemperCombo.setBounds(240,50,150,50);
        temperPanel.add(toLabel);
        toLabel.setBounds(210,50,20,50);

        temperPanel.add(from);
        from.setBounds(50,140,150,50);
        temperPanel.add(answerLabel);
        answerLabel.setOpaque(true);
        answerLabel.setBackground(Color.GRAY);
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(240, 140, 150,50);

        temperPanel.add(convertButton);
        convertButton.setOpaque(true);
        convertButton.setForeground(Color.WHITE);
        convertButton.setBackground(Color.BLACK);
        convertButton.setBounds(260, 220, 100,30);

        FirstTemperCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox test = (JComboBox)e.getSource();
                String item = (String) test.getSelectedItem();
                double index = test.getSelectedIndex();
                selectedDropIndex[0] = index;
            }
        });

        SecondTemperCombo.addActionListener(new ActionListener() {
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
                        temperPanel.remove(answerLabel);
                        analyzeInput();

                    }
                });

    }

    private void analyzeInput(){
        if(selectedDropIndex[0] == 0){
            if(selectedDropIndex[1] == 0){
                outputLabel(-1);
            } if(selectedDropIndex[1] == 1){
                //celsius
                outputLabel(FtoC(currentInput));
            } if(selectedDropIndex[1] == 2){
            //kel
                outputLabel(FtoK(currentInput));
        } }

        if(selectedDropIndex[0] == 1){
            if(selectedDropIndex[1] == 1){
                //error label
                outputLabel(-1);
            } if(selectedDropIndex[1] == 0){
                //fa
                outputLabel(CtoF(currentInput));
            } if(selectedDropIndex[1] == 2) {
                //kel
                outputLabel(CtoK(currentInput));
            }}

        if(selectedDropIndex[0] == 2){
            if(selectedDropIndex[1] == 2){
                //error label
                outputLabel(-1);
            } if(selectedDropIndex[1] == 0){
                //fa
                outputLabel(KtoF(currentInput));
            } if(selectedDropIndex[1] == 1){
                //celsius
                outputLabel(KtoC(currentInput));
            } }
    }

    private void outputLabel(double answer){
        if(answer == -1){
            answerLabel = new JLabel("Switch Conversion", SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.RED);
            answerLabel.setForeground(Color.WHITE);
            temperPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);
        } else {
            answerLabel = new JLabel(String.valueOf(answer), SwingConstants.CENTER);
            answerLabel.setOpaque(true);
            answerLabel.setBackground(Color.GRAY);
            answerLabel.setForeground(Color.WHITE);
            temperPanel.add(answerLabel);
            answerLabel.setBounds(240, 140, 150, 50);

            unitsLabel = new JLabel(convList[index],SwingConstants.CENTER);
            unitsLabel.setOpaque(true);
            unitsLabel.setBackground(Color.GRAY);
            unitsLabel.setForeground(Color.WHITE);
            temperPanel.add(unitsLabel);
            unitsLabel.setBounds(395,140,150,50);
        }
    }

    public JPanel getTemperPanel(){
        return temperPanel;
    }

    public double FtoC(double f){
        double c  = f-32 * 5/9;
        return c;
    }
    public double FtoK(double f){
        double k = (f-32) * (5/9) + 273.15;
        return k;
    }
    public double CtoF(double c){
        double f = (c* (9/5)) + 32;
        return f;
    }
    public double CtoK(double c){
        double k = c+273.15;
        return k;
    }
    public double KtoF(double k){
        double f = (k-273.15) * (9/5) + 32;
        return f;
    }
    public double KtoC(double k){
        double c = k-273.15;
        return c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
