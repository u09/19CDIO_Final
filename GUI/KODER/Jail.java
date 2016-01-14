package KODER;

import java.util.Map;

public class Jail extends Fields {
    
    private static boolean[] jailedPlayers={false,false,false,false,false,false};
    private static int[] Nthrows={0,0,0,0,0,0};
    private final Map<String, String> Lang=new Lang().lang("DA");
    
    public Jail(String name){
        super(name);
    }

    @Override
    public void landOnField(Players p){
        if(p.getPosition()==11 && jailedPlayers[p.getPlayer()]==false) return;
        if(jailedPlayers[p.getPlayer()]==false){
            GUI.setCar(11,p.name());
            GUI.removeCar(31,p.name());
            p.setPosition(11);
            jailedPlayers[p.getPlayer()]=true;
        }
        else{
            String b=GUI.getUserButtonPressed(Lang.get("iF�ngsel"),Lang.get("iF�ngselB"),Lang.get("iF�ngselT"));
            if(b==Lang.get("iF�ngselB")) payJail(p);
            else Nthrows[p.getPlayer()]++;
        }
        
    }
    
    public boolean isJailed(int p){
        return jailedPlayers[p];
    }
    public void payJail(Players p){
        p.remove(1000);
        jailedPlayers[p.getPlayer()]=false;
        Nthrows[p.getPlayer()]=0;
        
    }
    public int Nthrows(int p){
        return Nthrows[p];
    }
}
