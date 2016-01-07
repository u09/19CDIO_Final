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
        list.add(new desktop_fields.Start.Builder().setTitle("START").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Hvidovrevej").setBgColor(Color.BLUE).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("R�dovrevej").setBgColor(Color.BLUE).build());
        list.add(new desktop_fields.Tax.Builder().setTitle("Betal indkomstskat").setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Shipping.Builder().setTitle("Scandlines H-H").setBgColor(Color.BLUE).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Roskildevej").setBgColor(Color.ORANGE).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Valby Langgade").setBgColor(Color.ORANGE).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Allegade").setBgColor(Color.ORANGE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle("P� bes�g-I f�ngsel").setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Frederiksberg Alle").setBgColor(Color.GREEN).build());
        list.add(new desktop_fields.Brewery.Builder().setTitle("SQUASH").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Street.Builder().setTitle("B�lowsvej").setBgColor(Color.GREEN).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Gl.Kongevej").setBgColor(Color.GREEN).build());
        list.add(new desktop_fields.Shipping.Builder().setTitle("Mols Linjen").setBgColor(Color.BLUE).build());   
        list.add(new desktop_fields.Street.Builder().setTitle("Bernstorffsvej").setBgColor(Color.GRAY).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Hellerupvej").setBgColor(Color.GRAY).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Strandvejen").setBgColor(Color.GRAY).build());
        list.add(new desktop_fields.Empty.Builder().setBgColor(Color.PINK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Trianglen").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("�sterbrogade").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Gr�nningen").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Shipping.Builder().setTitle("Scandlines G-R").setBgColor(Color.BLUE).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Bredegade").setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Kgs. Nytorv").setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Brewery.Builder().setTitle("COCA COLA").setBgColor(Color.RED).build());
        list.add(new desktop_fields.Street.Builder().setTitle("�stergade").setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle("De f�ngsles").setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Amagertorv").setBgColor(Color.YELLOW).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Vimmelskaftet").setBgColor(Color.YELLOW).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Nygade").setBgColor(Color.YELLOW).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Scandlines R-P").setBgColor(Color.BLUE).build());
        list.add(new desktop_fields.Chance.Builder().setBgColor(Color.BLACK).build());
        list.add(new desktop_fields.Street.Builder().setTitle("Frederiksberggade").setBgColor(Color.MAGENTA).build());
        list.add(new desktop_fields.Tax.Builder().setTitle("SKAT 2000 kr").setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Street.Builder().setTitle("R�dhuspladsen").setBgColor(Color.MAGENTA).build());
        
       
        
        
        //Vi laver field array og definere længden af arrayet
        Field[] fields = new Field[list.size()];
        
        // Den overfører en indholdet fra den ene array til den anden.  
        for(int i = 0; i < fields.length; i++) fields[i] = list.get(i);
        GUI.create(fields);
    }
}

