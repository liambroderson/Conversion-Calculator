package com.test;

import javax.swing.*;
import java.awt.*;

public class History {
    public JPanel historyPanel = new JPanel();

    public History(){
        runHistoryPanel();
    }
    public void runHistoryPanel() {
        historyPanel.setLayout(null);
        historyPanel.setVisible(true);
    }

    public JPanel getHistoryPanel(){
        return historyPanel;
    }
}
