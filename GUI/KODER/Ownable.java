package KODER;

public abstract class Ownable extends Fields {
    private Players owner;
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
        if(this.owner != null){
            p.remove(getRent());
            this.owner.add(getRent());
        }
    }
    
    public abstract int getRent();
}
