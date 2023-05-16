import javax.swing.*;
import java.awt.*;

public class CJFrame extends JFrame {
    CGuiPanel guiPanel = new CGuiPanel();
    public CJFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.add(guiPanel);
    pack();
    setSize(new Dimension(1000,1000));
    }

}
