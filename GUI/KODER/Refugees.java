package KODER;

public class Refugees  extends Fields{ // forlænger klasse med en anden klasse
    private int bonus;
    
    public Refugees(String name, int bonus){ // konstruktør til at sætte feltets navn og leje
        super(name);
        setName(name);
        this.bonus=bonus;
    }
    
    @Override
    public void landOnField(Players player){
        
    }
}
