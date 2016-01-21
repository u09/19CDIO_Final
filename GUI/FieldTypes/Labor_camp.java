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
        Ownable O=(Ownable)FieldHandler.Field[12];// Kaster de 2 labor camp felter til Ownable
        Ownable O2=(Ownable)FieldHandler.Field[28];
        // Hvis en spiller ejer begge felter, skal lejen sættes til at være terningernes værdier multipliceret med lejen 2 gange
        if(O.getOwner()!=null && O.getOwner().name()==O2.getOwner().name()) this.rent=sum*rent*2;
        else this.rent=sum*rent;// ellers skal lejen bare være terningernes værdier multipliceret med lejen
    }

}
