package FieldTypes;

import java.util.Map;
import KODER.FieldHandler;
import KODER.Ownable;
import KODER.Players;

public class Fleet extends Ownable{
    private int rent;
    
    public Fleet(String name,int price, int rent){
        super(name,price);
    }
    
    @Override
    public int getRent(Players p){
        setRent(p);
        return this.rent;
    }
    
    private void setRent(Players p){
        FieldHandler f= new FieldHandler();
        Ownable O[]={(Ownable) f.Field[5],(Ownable) f.Field[15],(Ownable) f.Field[25],(Ownable) f.Field[35]};
        int[] amountp = {0,0,0,0,0,0};
        int n=p.getPosition();
        
        if(n==6) n=0;
        else if(n==16) n=1;
        else if(n==26) n=2;
        else n=3;
        
        if(O[0].getOwner()!=null) amountp[O[0].getOwner().getPlayer()]++;
        if(O[1].getOwner()!=null) amountp[O[1].getOwner().getPlayer()]++;
        if(O[2].getOwner()!=null) amountp[O[2].getOwner().getPlayer()]++;
        if(O[3].getOwner()!=null) amountp[O[3].getOwner().getPlayer()]++;
        
        if(p.getPlayer()==O[n].getOwner().getPlayer()) this.rent=0;
        else{
            if(amountp[O[n].getOwner().getPlayer()]==1) this.rent=500;
            else if(amountp[O[n].getOwner().getPlayer()]==2) this.rent=1000;
            else if(amountp[O[n].getOwner().getPlayer()]==3) this.rent=2000;
            else this.rent=4000;
        }
    }
}