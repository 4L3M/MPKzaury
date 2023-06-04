package mpkprojekt;

import java.util.ArrayList;

public abstract class CStop {
//    ArrayList<CAbstractTram> abstractTrams;
    CPosition pos;
    CPosition controlPos;
    CTram stoppedTram = null;
    public CStop(String position, String controlPosition/*,  ArrayList<CAbstractTram> abstractTrams*/) {
        pos = new CPosition(position);
        controlPos = new CPosition(controlPosition);
       // this.abstractTrams = abstractTrams;
    }
}