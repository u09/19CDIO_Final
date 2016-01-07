package KODER;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import desktop_fields.*;
import desktop_resources.GUI;

public class GameBoard {

    public GameBoard(){
        
    }
    //vi opretter en funktion til at oprette felter
    public void createBoard(Map<String, String> Lang) {
        //felterne bliver sat ind i et array
        ArrayList<Field> list = new ArrayList<Field>();
        //her tilføjer vi de enkelte felter,sætter baggrunden og titlen  ( op til 22)
        list.add(new Start.Builder().setTitle("START").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("TRIBE ENCAMPMENT").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("CRATER").setBgColor(Color.RED).build());
        list.add(new Shipping.Builder().setTitle("SECOND SAIL").setBgColor(Color.GREEN).build());
        list.add(new Refuge.Builder().setTitle("WALLED CITY").setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("MOUNTAIN").setBgColor(Color.RED).build());
        list.add(new Brewery.Builder().setTitle("HUTS IN THE MOUNTAIN").setBgColor(Color.PINK).build());
        list.add(new Street.Builder().setTitle("COLD DESERT").setBgColor(Color.RED).build());
        list.add(new Shipping.Builder().setTitle("SEA GROVER").setBgColor(Color.GREEN).build());
        list.add(new Street.Builder().setTitle("BLACK CAVE").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("THE WEREWALL").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("MOUNTAIN VILLAGE").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("CARAVAN").setBgColor(Color.GRAY).build());
        list.add(new Shipping.Builder().setTitle("THE BUCCANEERS").setBgColor(Color.GREEN).build());
        list.add(new Refuge.Builder().setTitle("MONASTERY").setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("SOUTH CITADEL").setBgColor(Color.RED).build());   
        list.add(new Street.Builder().setTitle("PALACE GATES").setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("GOLDMINE").setBgColor(Color.GRAY).build());
        list.add(new Shipping.Builder().setTitle("PRIVATE ARMADE").setBgColor(Color.GREEN).build());
        list.add(new Street.Builder().setTitle("TOWER").setBgColor(Color.RED).build());
        list.add(new Brewery.Builder().setTitle("THE PIT").setBgColor(Color.PINK).build());
        list.add(new Street.Builder().setTitle("CASTLE").setBgColor(Color.RED).build());
        
        //Vi laver field array og definere længden af arrayet
        Field[] fields = new Field[list.size()];
        
        // Den overfører en indholdet fra den ene array til den anden.  
        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);
        GUI.create(fields);
    }
}

