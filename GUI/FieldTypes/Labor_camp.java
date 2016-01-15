package FieldTypes;

import KODER.Dicecup;
import KODER.FieldHandler;
import KODER.Ownable;
import KODER.Players;

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
        Dicecup D=new Dicecup();
        int sum=D.sum();
        FieldHandler f=new FieldHandler();
        Ownable O=(Ownable)f.Field[12];
        Ownable O2=(Ownable)f.Field[28];
        if(O.getOwner()!=null && O.getOwner().name()==O2.getOwner().name()) this.rent=sum*rent*2;
        else this.rent=sum*rent;
    }

}
