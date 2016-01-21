package FieldTypes;

import java.util.Map;
import KODER.Fields;
import KODER.GUI;
import KODER.Lang;
import KODER.LuckController;
import KODER.Players;

public class Luck extends Fields {
    private final Map<String, String> Lang=new Lang().lang("DA");
    private static LuckController LuckConObj; // definere objektet
    
    public Luck(String name){
        super(name);
        // opretter objekt af LuckController, da vi skaal bruge metoder derfra
        LuckConObj=new LuckController();
    }
    
    @Override
    public void landOnField(Players p){
        String pickCard = GUI.getUserButtonPressed(Lang.get("PrøvL"), Lang.get("Y"), Lang.get("N"));
        if(pickCard==Lang.get("Y")) LuckConObj.getLuckCard(p);
    }
}
