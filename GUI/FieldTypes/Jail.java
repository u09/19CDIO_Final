package FieldTypes;

import java.util.Map;
import KODER.Fields;
import KODER.GUI;
import KODER.Lang;
import KODER.Players;

public class Jail extends Fields {
    /* Noter til denne klasse:
     * jailedPlayers bruges til at se om spillerne er fængslet, hvorfor der er 6.
     * static betyder at variablen ikke ændrer sig når man laver et nyt objekt af den.
     * Nthrows fortæller hvor mange gange hver spiller som sidder i fængsel har kastet.
     */ 
    private static boolean[] jailedPlayers={false,false,false,false,false,false};
    private static int[] Nthrows={0,0,0,0,0,0};// Array for antal gange man kaster for at komme ud af fængsel, når man er derinde
    private final Map<String, String> Lang=new Lang().lang("DA");
    public Jail(String name){
        super(name);
    }

    @Override
    public void landOnField(Players p){
        if(p.getPosition()==11 && jailedPlayers[p.getPlayer()]==false) return;// Man skal ikke ryge i fængsel, hvis man lander på felt 11(på besøg) 
        if(jailedPlayers[p.getPlayer()]==false){// Hvis man ryger i fængsel ved at slå terninger og komme til felt 31, sætter vi bilen over på felt 11, og sætter jailedPlayers til true
            GUI.removeCar(31,p.name());
            GUI.setCar(11,p.name());
            p.setPosition(11);
            jailedPlayers[p.getPlayer()]=true;
        }
        else{// Så har man valgmuligheden for, at enten betale 1000kr og komme ud af fængsel, eller kaste terninger
            String b=GUI.getUserButtonPressed(Lang.get("iFængsel"),Lang.get("iFængselB"),Lang.get("iFængselT"));
            if(b==Lang.get("iFængselB")) payJail(p);
            else Nthrows[p.getPlayer()]++;
        }
        
    }
    
    public boolean isJailed(int p){
        return jailedPlayers[p];
    }
    /**
     * Metode når man er inde i fængsel. At man skal betale 1000, og Nthrows ryger på 0
     * @param p
     */
    public void payJail(Players p){
        p.remove(1000);
        jailedPlayers[p.getPlayer()]=false;
        Nthrows[p.getPlayer()]=0;
        
    }
    /**
     * Metode til at se hvor mange gange man har kastet for at prøve at komme ud af fængsel
     * @param p
     * @return
     */
    public int Nthrows(int p){
        return Nthrows[p];
    }
}
