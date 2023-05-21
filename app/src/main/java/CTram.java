public class CTram extends CRepairTram{

    int line_number;
    int isWorking;
    Double delay;
    public CTram(int length, CPosition pos) {
       super(length, pos.x, pos.y);
       line_number = 0;
       isWorking = 0;
       delay = 0.0;

    }
}
