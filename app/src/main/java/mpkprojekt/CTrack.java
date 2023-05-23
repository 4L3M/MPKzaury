package mpkprojekt;

import java.awt.*;

public class CTrack implements Objects{
int occupied;
CPosition pos;
    public CTrack(int occupied, int x, int y) {
        this.occupied = occupied;
        this.pos = new CPosition(x, y);
    }

    @Override
    public void drawMe(Graphics2D G2D) {
    }
}
