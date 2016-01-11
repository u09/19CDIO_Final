package KODER;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import desktop_fields.*;
import desktop_resources.GUI;

public class GameBoard {
    
    public GameBoard() {
    
    }
    // vi opretter en funktion til at oprette felter
    public void createBoard(Map<String, String> Lang) {
        // felterne bliver sat ind i et array
        ArrayList<Field> list = new ArrayList<Field>();

        // her tilføjer vi de enkelte felter, sætter titlen, evt. undertitel og beskrivelse, baggrundensfarven (op til 40)
/*1*/   list.add(new Start.Builder().setTitle("START")
            .setSubText("")
            .setDescription("Hver gang De passerer START, modtag kr. 4000")
            .setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("Hvidovrevej")
            .setSubText("kr. 1200")
            .setBgColor(Color.BLUE).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Rodovervej")
            .setSubText("kr. 1200")
            .setBgColor(Color.BLUE).build());
/*5*/   list.add(new desktop_fields.Tax.Builder().setTitle("Skat")
            .setSubText("Betal indkomstskat: 10% eller kr. 4000")
            .setDescription("Betal indkomstskat: 10% eller kr. 4000")
            .setBgColor(Color.WHITE).build());
        list.add(new Shipping.Builder().setTitle("Scandlines H-H")
            .setSubText("kr. 4000")
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Roskildevej")
            .setSubText("kr. 2000")
            .setBgColor(Color.ORANGE).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Valby Langgade")
            .setSubText("kr. 2000")
            .setBgColor(Color.ORANGE).build());
/*10*/  list.add(new Street.Builder().setTitle("Allegade")
            .setSubText("kr. 2400")
            .setBgColor(Color.ORANGE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle("På besøg")
            .setSubText("I fængsel")
            .setDescription("De er på besøg i fængslet")
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Frederiksberg Alle")
            .setSubText("kr. 2800")
            .setBgColor(Color.GREEN).build());
        list.add(new Brewery.Builder().setTitle("SQUASH")
            .setSubText("kr. 3000")
            .setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("Bulowsvej")
            .setSubText("kr. 2800")
            .setBgColor(Color.GREEN).build());
/*15*/  list.add(new Street.Builder().setTitle("Gl.Kongevej")
            .setSubText("kr. 3200")
            .setBgColor(Color.GREEN).build());
        list.add(new Shipping.Builder().setTitle("Mols Linjen")
            .setSubText("kr. 4000")
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Bernstorffsvej")
            .setSubText("kr. 3600")
            .setBgColor(Color.GRAY).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Hellerupvej")
            .setSubText("kr. 3600")
            .setBgColor(Color.GRAY).build());
/*20*/  list.add(new Street.Builder().setTitle("Strandvejen")
            .setSubText("kr. 4000")
            .setBgColor(Color.GRAY).build());
        list.add(new Empty.Builder()
            .setBgColor(Color.PINK).build());
        list.add(new Street.Builder().setTitle("Trianglen")
            .setSubText("kr. 4400")
            .setBgColor(Color.RED).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Osterbrogade")
            .setSubText("kr. 4400")
            .setBgColor(Color.RED).build());
/*25*/  list.add(new Street.Builder().setTitle("Gronningen")
            .setSubText("kr. 4800")
            .setBgColor(Color.RED).build());
        list.add(new Shipping.Builder().setTitle("Scandlines G-R")
            .setSubText("kr. 4000")
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Bredegade")
            .setSubText("kr. 5200")
            .setBgColor(Color.WHITE).build());
        list.add(new Street.Builder().setTitle("Kgs. Nytorv")
            .setSubText("kr. 5200")
            .setBgColor(Color.WHITE).build());
        list.add(new Brewery.Builder().setTitle("COCA COLA")
            .setSubText("kr. 3000")
            .setBgColor(Color.RED).build());
/*30*/  list.add(new Street.Builder().setTitle("Ostergade")
            .setSubText("kr. 5600")
            .setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle("De fængsles")
            .setSubText("De fængsles")
            .setDescription("De fængsles! Ryk frem til 'I fængsel'")
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Amagertorv")
            .setSubText("kr. 6000")
            .setBgColor(Color.YELLOW).build());
        list.add(new Street.Builder().setTitle("Vimmelskaftet")
            .setSubText("kr. 6000")
            .setBgColor(Color.YELLOW).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
/*35*/  list.add(new Street.Builder().setTitle("Nygade")
            .setSubText("kr. 6400")
            .setBgColor(Color.YELLOW).build());
        list.add(new Shipping.Builder().setTitle("Scandlines R-P")
            .setSubText("kr. 4000")
            .setBgColor(Color.BLUE).build());
        list.add(new Chance.Builder()
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Frederiksberggade")
            .setSubText("kr. 7000")
            .setBgColor(Color.MAGENTA).build());
        list.add(new desktop_fields.Tax.Builder().setTitle("Skat")
            .setSubText("Betal indkomstskat: 10% eller kr. 4000")
            .setDescription("Ekstraordinær statsskat: Betal kr. 2000")
            .setBgColor(Color.WHITE).build());
/*40*/  list.add(new Street.Builder().setTitle("Radhuspladsen")
            .setSubText("kr. 8000").
            setBgColor(Color.MAGENTA).build());
            
        //Vi laver field array og definere længden af arrayet
        Field[] fields = new Field[list.size()];
        
        // Den overfører en indholdet fra den ene array til den anden.
        for (int i = 0; i < fields.length; i++)
            fields[i] = list.get(i);
        GUI.create(fields);
    }
}
