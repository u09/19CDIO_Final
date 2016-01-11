package KODER;

import java.util.Map;

public class Fleet extends Ownable{
    private int rent;
    
    public Fleet(String name,int price, int rent){
        super(name,price);
    }
    
    @Override
    public int getRent(Players p){
        setRent(rent,p);
        return this.rent;
    }
    
    private void setRent(int rent,Players p){
        FieldHandler f= new FieldHandler();
        Ownable O[]={(Ownable) f.Field[5],(Ownable) f.Field[15],(Ownable) f.Field[25],(Ownable) f.Field[35]};
        int[] amountp = {0,0,0,0,0,0};
        int n=p.getPosition();
        
        if(n==5) n=0;
        else if(n==15) n=1;
        else if(n==25) n=2;
        else n=3;
        
        amountp[O[0].getOwner().getPlayer()]++;
        amountp[O[1].getOwner().getPlayer()]++;
        amountp[O[2].getOwner().getPlayer()]++;
        amountp[O[3].getOwner().getPlayer()]++;
        
        if(p.getPlayer()==O[n].getOwner().getPlayer()) this.rent=0;
        else rent=amountp[O[n].getOwner().getPlayer()];
    }
}