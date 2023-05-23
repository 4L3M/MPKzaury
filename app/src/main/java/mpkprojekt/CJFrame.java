package mpkprojekt;

import javax.swing.*;
import java.awt.*;

public class CJFrame extends JFrame {
    CGuiPanel guiPanel ;

    public CJFrame() {
        guiPanel = new CGuiPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(guiPanel);
        pack();
        setSize(new Dimension(500, 500));
        guiPanel.repaint();

    }
}