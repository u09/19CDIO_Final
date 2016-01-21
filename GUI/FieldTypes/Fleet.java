package FieldTypes;

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
    /**Metode for at sætte den korrekte leje afhængig af antal fleets ejet.
     * @param Players p
     */
    private void setRent(Players p){
        Ownable O[]={(Ownable) FieldHandler.Field[5],(Ownable) FieldHandler.Field[15],(Ownable) FieldHandler.Field[25],(Ownable) FieldHandler.Field[35]};
        int[] amountp = {0,0,0,0,0,0};// Laver et array med hvor mange fleet felter de forskellige spillere ejer
        int n=p.getPosition();
        
        // Definerer de forskellige felter fleet ligger på
        if(n==6) n=0;
        else if(n==16) n=1;
        else if(n==26) n=2;
        else n=3;
        
        // Hvis man køber et felt, vil man inde i arrayet få et fleet felt mere, altså "amountp" inkrementeres.
        if(O[0].getOwner()!=null) amountp[O[0].getOwner().getPlayer()]++;
        if(O[1].getOwner()!=null) amountp[O[1].getOwner().getPlayer()]++;
        if(O[2].getOwner()!=null) amountp[O[2].getOwner().getPlayer()]++;
        if(O[3].getOwner()!=null) amountp[O[3].getOwner().getPlayer()]++;
        
        // Hvis spilleren der lander på det pågældende fleet felt selv ejer det, skal der ikke betales noget
        if(p.getPlayer()==O[n].getOwner().getPlayer()) this.rent=0;
        // Jo flere de ejer, jo højere bliver lejen for at lande der 
        else{
            if(amountp[O[n].getOwner().getPlayer()]==1) this.rent=500;
            else if(amountp[O[n].getOwner().getPlayer()]==2) this.rent=1000;
            else if(amountp[O[n].getOwner().getPlayer()]==3) this.rent=2000;
            else this.rent=4000;
        }
    }
}