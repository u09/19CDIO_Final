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
        if(p.getPosition()==39) this.tax=2000;
        else{
            String b = GUI.getUserButtonPressed(Lang.get("TAX_Check"), Lang.get("B4000"), Lang.get("B10"));
            if(b==Lang.get("B4000")) this.tax=4000;
            else{
                FieldHandler f= new FieldHandler();
                int EjendomSum = 0; 
                Ownable O;
                
                for(int i=1;i<=f.Field.length;i++){
                    if(f.Field[i-1] instanceof Ownable){
                        O=(Ownable) f.Field[i-1];
                        if(O.getOwner()!=null && O.getOwner().getPlayer()==p.getPlayer()) EjendomSum +=O.getPrice();
                    }
                }
                this.tax=(p.getMoney()+EjendomSum)/this.taxRate;
            }
        }
        p.remove(this.tax);
    }
}
