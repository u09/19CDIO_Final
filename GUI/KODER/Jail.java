package KODER;

public class Jail extends Fields {
    
    private boolean[] jailedPlayers={false,false,false,false,false,false};
    private int[] Nthrows={0,0,0,0,0,0};
    
    public Jail(String name){
        super(name);
    }

    @Override
    public void landOnField(Players p) {
        if(jailedPlayers[p.getPlayer()]==false){
        GUI.setCar(11,getName());
        p.setPosition(11);
        jailedPlayers[p.getNumber()]=true;
        }
        else{
        String b=GUI.getUserButtonPressed("Vil du betale 1000 eller slå med terninger","Betal 1000","Slå med terninger");
        if(b=="Betal 1000")
            payJail(p);
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
