package mpkprojekt;

import java.awt.*;

public class CTrack implements Objects{
int occupied;
CPosition pos;
    public CTrack(int occupied, int x, int y) {
        this.occupied = occupied;
        this.pos = new CPosition(x, y);
    }

    public CTrack(String xy) {
        this.occupied = 0; // 0 - free; 1 - occupied
        this.pos = new CPosition(xy);
    }

    @Override
    public void drawMe(Graphics2D G2D) {
        G2D.setColor(Color.white);
        G2D.fillRect(pos.x * 10, pos.y * 10,10,10);
    }
}
