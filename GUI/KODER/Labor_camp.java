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
        Dicecup D = new Dicecup();
        D.Throw();
        int sum = D.sum();
        FieldHandler f= new FieldHandler();
        Ownable O[]={(Ownable) f.Field[13],(Ownable) f.Field[29]};
        int[] amountp = {0,0,0,0,0,0};
        int n=p.getPosition();
        
        if(n==13) n=0;
        else if(n==29) n=1;
        
        if(O[0].getOwner()!=null) amountp[O[0].getOwner().getPlayer()]++;
        if(O[1].getOwner()!=null) amountp[O[1].getOwner().getPlayer()]++;
        
        if(p.getPlayer()==O[n].getOwner().getPlayer()) this.rent=0;
        else{
            if(amountp[O[n].getOwner().getPlayer()]==1) this.rent=sum*rent;
            else if(amountp[O[n].getOwner().getPlayer()]==2) this.rent=sum*rent*2;       
        }    
    }
}
