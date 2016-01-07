package KODER;

public class Labor_camp extends Ownable{
    private int rent;
    
    public Labor_camp(String name,int price,int rent){
        super(name,price);
        setRent(rent);
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        Dicecup D = new Dicecup();
        D.Throw();
        int s = D.sum();
        this.rent=rent;
        FieldHandler f = new FieldHandler();
        Ownable O = (Ownable) f.Field[12];
        Ownable O2 = (Ownable) f.Field[28];
        if(O.getOwner().name()==O2.getOwner().name()){
            this.rent = s*rent*2;
            
        }
    }
}
