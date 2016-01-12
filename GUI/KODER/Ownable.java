package KODER;

public abstract class Ownable extends Fields {
    protected Players owner;
    private int price;
    
    public Ownable(String name,int price){
        super(name);
        this.setPrice(price);
    }
    
    public Players getOwner() {
        return owner;
    }

    public void setOwner(Players owner) {
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
           String k = GUI.getUserButtonPressed("Vil du købe grunden?", "Ja" , "Nej");
            if(k=="Ja"){
                this.owner=p;
                GUI.setOwner(p.getPosition(),p.name());
                p.remove(getPrice());
            }
        }
        else{
            p.remove(getRent(p));
            this.owner.add(getRent(p));
        }
            
    }
    
    public abstract int getRent(Players p);
    }
