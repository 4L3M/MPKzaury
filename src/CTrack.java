public class CTrack {
int occupied;
CPosition pos;
    public CTrack(int occupied, int x, int y) {
        this.occupied = occupied;
        this.pos = new CPosition(x, y);
    }
}
