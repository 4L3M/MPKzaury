package mpkprojekt;

public abstract class CAbstractTram {
    CPosition pos = null;
    int length=-1;

    public CAbstractTram(int x, int y, int length) {
        this.pos = new CPosition(x,y);
        this.length = length;
    }
}
