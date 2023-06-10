package mpkprojekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CGuiPanel extends JPanel {
    private int width = 1900;
    private int heigth = 1000;
    private char [][] array = new char[10000][10000];
    private int maxc = 0;   // max column
    private int maxr = 0;   // max row
    public ArrayList <Objects> objects = null;
    CClock clock;
    ArrayList <CAbstractTram> abstractTrams = null;
    public CGuiPanel( ArrayList<CAbstractTram> abstractTrams,CClock clock){
        this.setPreferredSize(new Dimension(width,heigth));
        this.abstractTrams = abstractTrams;
        this.clock = clock;
        readMap();
    }
   private void readMap(){
        File file = new File("TestMap"); // Otwieranie pliku o podanej nazwie
        Scanner scanner = null; // Tworzy obiekt typu Scanner
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Niewlasciwy plik");
        }
        List<String> list = new ArrayList<>(); // Utworzenie listy
        for(;scanner.hasNextLine();){ // Tak dlugo dodawaj do listy, dopóki w pliku są kolejne linie
            list.add(scanner.nextLine()); // Wczytanie do listy poszczególnych wierszy
        }
        maxr = list.size();
        for(String s: list){
            if(maxc < s.length()) maxc = s.length();
        }
        for(int i = 0; i<maxr;i++){
            for (int j = 0; j<maxc;j++){
                array[i][j] = list.get(i).charAt(j);
            }
        }


    }
    public void paint(Graphics G){
        Graphics2D G2D = (Graphics2D) G;
        int x = 10, y = 10;
        for(int i = 0; i<maxr;i++){
            for (int j = 0; j<maxc;j++){
               if(array[i][j]=='B'||array[i][j]=='A'||array[i][j]=='1'||array[i][j]=='0'|| array[i][j]=='4'|| array[i][j]=='5'|| array[i][j]=='7'|| array[i][j]=='8'){
                    G2D.setColor(Color.orange.darker().darker());}
                if(array[i][j]==' '){
                    G2D.setColor(Color.GREEN.brighter());}
                if(array[i][j]=='W'){
                    G2D.setColor(Color.cyan.darker());}
                if (array[i][j]=='T'){
                    G2D.setColor(Color.BLUE);}
                G2D.fillRect(10+j*10,10+i*10,10,10);
            }
        }

        for (Objects o: objects){
           o.drawMe(G2D);
        }
        for(CAbstractTram a: abstractTrams){
            a.drawMe(G2D);
        }
        G2D.setColor(Color.BLACK);
        G2D.fillRect(1150,50,100,50);
        G2D.setColor(Color.white);
        G2D.fillRect(1155,55,90,40);
        G2D.setColor(Color.black);
        G2D.setFont(new Font("Arial",Font.BOLD,16));
        G2D.drawString(clock.getTime(),1170,80);
    }
    }