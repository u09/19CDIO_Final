package FieldTypes;

import java.util.Map;
import KODER.FieldHandler;
import KODER.Fields;
import KODER.GUI;
import KODER.Lang;
import KODER.Ownable;
import KODER.Players;

public class Tax extends Fields{ // forlænger klasse med en anden klasse
    private int tax;
    private int taxRate=10;
    private final Map<String, String> Lang=new Lang().lang("DA");
    
    public Tax(String name, int tax){ // Konstruktør til at sætte fæltnavn og lejen
        super(name);
        this.tax=tax;
    }
    
    @Override
    public void landOnField(Players p){
        // Hvis man lander på felt 39, skal man betale 2000
        if(p.getPosition()==39) this.tax=2000;
        // Hvis man lander på felt 5, skal man enten betale 4000 eller 10% af al ejendom
        else{
            String b = GUI.getUserButtonPressed(Lang.get("TAX_Check"), Lang.get("B4000"), Lang.get("B10"));
            if(b==Lang.get("B4000")) this.tax=4000;
            else{
                int EjendomSum = 0; 
                Ownable O;
                // Vi looper igennem alle felter som er ownable
                for(int i=1;i<=FieldHandler.Field.length;i++){
                    if(FieldHandler.Field[i-1] instanceof Ownable){
                        // Vi kaster arrayet fra FieldHandler til Ownable
                        O=(Ownable) FieldHandler.Field[i-1];
                        // Vi sætter ejendomSum til at blive inkrementeret med priserne for alle hans felter
                        if(O.getOwner()!=null && O.getOwner().getPlayer()==p.getPlayer()) EjendomSum+=O.getPrice();
                    }
                }
                // Vi sætter tax til at være alt hans ejendom+pengebeholdning, som skal divideres med 10
                this.tax=(p.getMoney()+EjendomSum)/this.taxRate;
            }
        }
        p.remove(this.tax);
    }
}
