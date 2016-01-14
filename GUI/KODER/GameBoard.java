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
            .setDescription(Lang.get("StartPenge"))
            .setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("Rødovervej")
            .setSubText("kr. 1200")
            .setDescription("Rødovervej")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
        list.add(new Street.Builder().setTitle("Hvidovrevej")
            .setSubText("kr. 1200")
            .setDescription("Hvidovrevej")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
/*5*/   list.add(new desktop_fields.Tax.Builder().setTitle("Skat")
            .setSubText(Lang.get("TAX_Check"))
            .setDescription(Lang.get("TAX_Check"))
            .setBgColor(Color.WHITE).build());
        list.add(new Shipping.Builder().setTitle("Scandlines 1")
            .setSubText("kr. 4000")
            .setDescription("Scandlines Helsingør - Helsingborg")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Roskildevej")
            .setSubText("kr. 2000")
            .setDescription("Roskildevej")
            .setBgColor(Color.ORANGE).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
        list.add(new Street.Builder().setTitle("Valby Langgade")
            .setSubText("kr. 2000")
            .setDescription("Valby Langgade")
            .setBgColor(Color.ORANGE).build());
/*10*/  list.add(new Street.Builder().setTitle("Allégade")
            .setSubText("kr. 2400")
            .setDescription("Allégade")
            .setBgColor(Color.ORANGE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle("På besøg")
            .setSubText("I fængsel")
            .setDescription(Lang.get("Besøg"))
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Frederiksberg Allé")
            .setSubText("kr. 2800")
            .setDescription("Frederiksberg Allé")
            .setBgColor(Color.GREEN).build());
        list.add(new Brewery.Builder().setTitle("Squash")
            .setSubText("kr. 3000")
            .setDescription("Tapperi - Tuborg Squash")
            .setBgColor(Color.RED).build());
        list.add(new Street.Builder().setTitle("Bülowsvej")
            .setSubText("kr. 2800")
            .setDescription("Bülowsvej")
            .setBgColor(Color.GREEN).build());
/*15*/  list.add(new Street.Builder().setTitle("Gl. Kongevej")
            .setSubText("kr. 3200")
            .setDescription("Gl.Kongevej")
            .setBgColor(Color.GREEN).build());
        list.add(new Shipping.Builder().setTitle("Mols-Linjen")
            .setSubText("kr. 4000")
            .setDescription("Mols-Linjen - Din genvej i Danmark")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Bernstorffsvej")
            .setSubText("kr. 3600")
            .setDescription("Bernstorffsvej")
            .setBgColor(Color.GRAY).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
        list.add(new Street.Builder().setTitle("Hellerupvej")
            .setSubText("kr. 3600")
            .setDescription("Hellerupvej")
            .setBgColor(Color.GRAY).build());
/*20*/  list.add(new Street.Builder().setTitle("Strandvejen")
            .setSubText("kr. 4000")
            .setDescription("Strandvejen")
            .setBgColor(Color.GRAY).build());
        list.add(new Empty.Builder()
            .setBgColor(Color.LIGHT_GRAY).build());
        list.add(new Street.Builder().setTitle("Trianglen")
            .setSubText("kr. 4400")
            .setDescription("Trianglen")
            .setBgColor(Color.RED).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
        list.add(new Street.Builder().setTitle("Østerbrogade")
            .setSubText("kr. 4400")
            .setDescription("Østerbrogade")
            .setBgColor(Color.RED).build());
/*25*/  list.add(new Street.Builder().setTitle("Grønningen")
            .setSubText("kr. 4800")
            .setDescription("Grønningen")
            .setBgColor(Color.RED).build());
        list.add(new Shipping.Builder().setTitle("Scandlines 2")
            .setSubText("kr. 4000")
            .setDescription("Scandlines Gedser-Rostock")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
        list.add(new Street.Builder().setTitle("Bredegade")
            .setSubText("kr. 5200")
            .setDescription("Bredegade")
            .setBgColor(Color.WHITE).build());
        list.add(new Street.Builder().setTitle("Kgs. Nytorv")
            .setSubText("kr. 5200")
            .setDescription("Kgs. Nytorv")
            .setBgColor(Color.WHITE).build());
        list.add(new Brewery.Builder().setTitle("Coca Cola")
            .setSubText("kr. 3000")
            .setDescription("Tapperi - Coca Cola")
            .setBgColor(Color.RED).build());
/*30*/  list.add(new Street.Builder().setTitle("Østergade")
            .setSubText("kr. 5600")
            .setDescription("Østergade")
            .setBgColor(Color.WHITE).build());
        list.add(new desktop_fields.Jail.Builder().setTitle(Lang.get("Fængsles"))
            .setSubText(Lang.get("Fængsles"))
            .setDescription(Lang.get("FængslesD"))
            .setBgColor(Color.CYAN).build());
        list.add(new Street.Builder().setTitle("Amagertorv")
            .setSubText("kr. 6000")
            .setDescription("Amagertorv")
            .setBgColor(Color.YELLOW).build());
        list.add(new Street.Builder().setTitle("Vimmelskaftet")
            .setSubText("kr. 6000")
            .setDescription("Vimmelskaftet")
            .setBgColor(Color.YELLOW).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
/*35*/  list.add(new Street.Builder().setTitle("Nygade")
            .setSubText("kr. 6400")
            .setDescription("Nygade")
            .setBgColor(Color.YELLOW).build());
        list.add(new Shipping.Builder().setTitle("Scandlines 3")
            .setSubText("kr. 4000")
            .setDescription("Scandlines Rødby-Puttgarden")
            .setFgColor(Color.WHITE)
            .setBgColor(Color.BLUE).build());
        list.add(new Chance.Builder()
            .setFgColor(Color.GREEN)
            .setBgColor(Color.BLACK).build());
        list.add(new Street.Builder().setTitle("Frederiksberggade")
            .setSubText("kr. 7000")
            .setDescription("Frederiksberggade")
            .setBgColor(Color.MAGENTA.darker()).build());
        list.add(new desktop_fields.Tax.Builder().setTitle("Skat")
            .setSubText(Lang.get("TAX_Check2"))
            .setDescription(Lang.get("TAX_Check2"))
            .setBgColor(Color.WHITE).build());
/*40*/  list.add(new Street.Builder().setTitle("Rådhuspladsen")
            .setSubText("kr. 8000")
            .setDescription("Rådhuspladsen")
            .setBgColor(Color.MAGENTA.darker()).build());
            
        //Vi laver field array og definere længden af arrayet
        Field[] fields = new Field[list.size()];
        
        // Den overfører en indholdet fra den ene array til den anden.
        for (int i = 0; i < fields.length; i++)
            fields[i] = list.get(i);
        GUI.create(fields);
    }
}
