package KODER;

public class Bank {
    private int money = 30000;
    private boolean dead=false;
    public Bank(){ // Konstruktør
        
    }
    
    public int getMoney(){ // Metode til at retunere penge
        return this.money;
    }
    
    public void Add(int money){ // metode til at tilføje penge
        this.money+=money;
        // Hvis spiller har en pengebeholdning over 0 efter der er blevet tilføjet penge til spilleren, er han ikke død længere.
        if(this.money>=0 && this.dead==true) this.dead=false; 
    }
    
    public void Substract(int money){ // metode til at trække penge
        this.money-=money;
        // Hvis spiller har en pengebeholdning under 0 efter der er blevet fjernet penge fra spilleren, er han død.
        if(this.money<0) this.dead=true;
    }
    
    public boolean dead(){ // metode til at tjekke om spiller er død
        return dead;
    }
}