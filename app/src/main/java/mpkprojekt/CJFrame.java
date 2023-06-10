package mpkprojekt;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CJFrame extends JFrame {
    CGuiPanel guiPanel ;

    public CJFrame(ArrayList <CAbstractTram> abstractTrams,CClock clock) {
        guiPanel = new CGuiPanel(abstractTrams,clock);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(guiPanel);
        pack();
        setSize(new Dimension(1900, 1000));
        guiPanel.repaint();

    }
}