public class CRepairTram {
    int length;
    CPosition pos = null;

    public CRepairTram(int length, int x, int y) {
        this.length = length;
        this.pos = new CPosition(x,y);
    }
}