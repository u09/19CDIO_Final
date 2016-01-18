package KODER;

import java.util.Map;
import FieldTypes.Jail;

public abstract class Ownable extends Fields {
    /* Noter til denne klasse:
     * Protected betyder at variablen eller metoden kun kan tilgås fra den samme klasse eller fra en nedarvet klasse.
     * super metoden sender variablen name videre til super klassen hvor den bliver brugt i konstruktøren.
     * 
     */ 
    protected Players owner;
    private int price;
    private final Map<String, String> Lang=new Lang().lang("DA");
    
    public Ownable(String name,int price){
        super(name);
        setPrice(price);
    }
    
    public Players getOwner() {
        return owner;
    }

    public void setOwner(Players owner){
        this.owner = owner;
    }
    
    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public void landOnField(Players p) {
        if(this.owner == null && p.getMoney()-this.price>=0){
            String k = GUI.getUserButtonPressed(Lang.get("KG"), Lang.get("Y") , Lang.get("N"));
            if(k==Lang.get("Y")){
                this.owner=p;
                GUI.setOwner(p.getPosition(),p.name());
                p.remove(getPrice());
            }
        }
        else if(this.owner == null && p.getMoney()-this.price<0) GUI.showMessage(Lang.get("IKKE_NOK_PENGE"));
        else{
            Jail J = new Jail("");
            if(J.isJailed(this.owner.getPlayer())==false){
                if(this.owner.name()!=p.name()){
                    GUI.showMessage(Lang.get("BETAL")+getRent(p)+Lang.get("TIL")+p.name());
                    p.remove(getRent(p));
                    this.owner.add(getRent(p));   
                }
            }
        }
            
    }
    
    /**
     * Den abstrakte metode for at få lejen til hvert Ownable felt. Denne metode specificeres i under hvert felt.
     * @param p Object af Players
     * @return
     */
    public abstract int getRent(Players p);
}