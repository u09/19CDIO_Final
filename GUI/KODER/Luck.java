package KODER;

import java.util.Map;

public class Luck extends Fields {
    private final Map<String, String> Lang=new Lang().lang("DA");
    private static LuckController LuckConObj;
    
    public Luck(String name){
        super(name);
        LuckConObj=new LuckController();
    }
    
    @Override
    public void landOnField(Players p){
        String pickCard = GUI.getUserButtonPressed(Lang.get("PrøvL"), Lang.get("Y"), Lang.get("N"));
        if(pickCard==Lang.get("Y")) LuckConObj.getLuckCard(p);
    }
}
