package KODER;

public class Labor_camp extends Ownable{
    private int rent;
    
    public Labor_camp(String name,int price,int rent){
        super(name,price);
    }
    
    @Override
    public int getRent(Players p){
        setRent(rent,p);
        return this.rent;
    }
    
    private void setRent(int rent,Players p){
        /*
        Dicecup D=new Dicecup();
        D.Throw();
        int sum=D.sum();
        FieldHandler f=new FieldHandler();
        Ownable O=(Ownable)f.Field[12];
        Ownable O2=(Ownable)f.Field[28];
        if(O.getOwner().name()==O2.getOwner().name()) this.rent=sum*rent*2;
        else if(O.getOwner().name() != O2.getOwner().name()) this.rent=sum*rent;
        else if(O.getOwner().name()==null || O2.getOwner().name()==null) this.rent=0;
        */
    }

    public void landOnField(Players player) {
        
    }
}
