package mpkprojekt;

import java.awt.*;

public class CTram extends CAbstractTram implements Objects{

    int line_number;
    int isWorking;
    Double delay;
    public CTram(int x , int y, int length, int line_number) {
        super(x,y,length);
       this.line_number = line_number;
       isWorking = 0;
       delay = 0.0;

    }

    @Override
    public void drawMe(Graphics2D G2D) {
    }
}