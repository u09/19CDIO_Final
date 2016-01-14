package KODER;

import java.util.Map;

public abstract class Ownable extends Fields {
    protected Players owner;
    private int price;
    private final Map<String, String> Lang=new Lang().lang("DA");
    
    public Ownable(String name,int price){
        super(name);
        this.setPrice(price);
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
        if(this.owner == null){
            String k = GUI.getUserButtonPressed(Lang.get("KG"), Lang.get("Y") , Lang.get("N"));
            if(k==Lang.get("Y")){
                this.owner=p;
                GUI.setOwner(p.getPosition(),p.name());
                p.remove(getPrice());
            }
        }
        else{
            Jail J = new Jail(p.name());
            if(J.isJailed(this.owner.getPlayer())==false){
                if(this.owner.name()!=p.name()){
                    GUI.showMessage(Lang.get("BETAL"));
                    p.remove(getRent(p));
                    this.owner.add(getRent(p));   
                }
            }
        }
            
    }
    
    public abstract int getRent(Players p);
    }
