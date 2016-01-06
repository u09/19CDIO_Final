package KODER;

public class Jail extends Fields {
    
    private boolean[] jailedPlayers={false,false,false,false,false,false};
    private int[] Nthrows={0,0,0,0,0,0};
    
    public Jail(String name){
        super(name);
    }

    @Override
    public void landOnField(Players p) {
        GUI.setCar(10,getName());
        jailedPlayers[p.getNumber()]=true;
    }
    public void inJail(){
        
    }
    //

}
