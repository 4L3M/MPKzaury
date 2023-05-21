import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CJFrame extends JFrame {
    CGuiPanel guiPanel = new CGuiPanel();

    public CJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(guiPanel, BorderLayout.WEST);
        pack();
        setSize(new Dimension(500, 500));
    }
}