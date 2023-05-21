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
    int width = 1900;
    int heigth = 1050;
    char [][] array = new char[10000][10000];
    int maxc = 0;   // max column
    int maxr = 0;   // max row
    public CGuiPanel(){
        this.setPreferredSize(new Dimension(width,heigth));
        repaint();
    }
    public void readMap(){
        File file = new File("C:\\MPKprojekt\\TestMap"); // Otwieranie pliku o podanej nazwie
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
        System.out.println(maxc+"\n"+maxr);
        for(int i = 0; i<maxr;i++){
            for (int j = 0; j<maxc;j++){
                array[i][j] = list.get(i).charAt(j);
            }
        }
       /* for(int i = 0; i<maxr;i++){
            for (int j = 0; j<maxc;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }*/



    }
    public void paint(Graphics G){
        Graphics2D G2D = (Graphics2D) G;
       /* G2D.setColor(Color.PINK);
        G2D.fillRect(10,10,100,100);
        G2D.setColor(Color.BLUE);
        G2D.fillRect(110,10,100,100);
        G2D.setColor(Color.ORANGE);
        G2D.fillRect(110,110,100,100);
        G2D.setColor(Color.GREEN);
        G2D.fillRect(10,110,100,100);*/

        int x = 10, y = 10;
        for(int i = 0; i<maxr;i++){
            for (int j = 0; j<maxc;j++){
                if(array[i][j]=='B'){
                    G2D.setColor(Color.PINK);}
                if(array[i][j]==' '){
                    G2D.setColor(Color.GREEN);}
                if (array[i][j]=='T'){
                    G2D.setColor(Color.BLUE);}
                G2D.fillRect(10+j*10,10+i*10,10,10);
            }
        }
    }

    }
