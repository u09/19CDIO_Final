package KODER;

public class Bank {
    private int money = 30000;
    private boolean dead=false;
    // Konstruktør
    public Bank(){
        
    }
    // Metode til at retunere penge
    public int getMoney(){
        return this.money;
    }
    // Metode til at tilføje penge
    public void Add(int money){
        this.money+=money;
        // Hvis spiller har en pengebeholdning over 0 efter der er blevet tilføjet penge til spilleren, er han ikke død længere.
        if(this.money>=0 && this.dead==true) this.dead=false; 
    }
    // Metode til at trække penge
    public void Substract(int money){
        this.money-=money;
        // Hvis spiller har en pengebeholdning under 0 efter der er blevet fjernet penge fra spilleren, er han død.
        if(this.money<0) this.dead=true;
    }
    // Metode til at tjekke om spiller er død
    public boolean dead(){
        return dead;
    }
}