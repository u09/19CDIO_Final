package KODER;

import java.awt.Color;
import java.util.Map;
import desktop_codebehind.Car;
import desktop_resources.GUI;

public class Players {
    private int position;
    private String name;
    private Bank money;
    private int player;
    
    /**
     * vi opretter konstuktør Players som tager imod type(bil,ufo,racer,traktor) og farven og til sidst sprogpakken
     * @param name
     * @param col
     * @param type
     * @param Lang
     */
    public Players(String name,String col,String type,Map<String, String> Lang, int player){
        this.name=name;
        this.position=1;
        this.money=new Bank();
        this.player=player;
        Color chk=Color.BLACK;
        
        // Brugeren får mulighed for at vælge farve i GUI'en
        if(col==Lang.get("F1")) chk=Color.BLUE;
        else  if(col==Lang.get("F2")) chk=Color.WHITE;
        else  if(col==Lang.get("F3")) chk=Color.BLACK;
        else  if(col==Lang.get("F4")) chk=Color.YELLOW;
        else  if(col==Lang.get("F5")) chk=Color.GREEN;
        else chk=Color.RED;
        
        //Brugeren får mulighed for at vælge køretøjer (UFO,RACER,NORMALBIL,TRACTOR)
        Car car;
        if(type==Lang.get("T1")) car=new Car.Builder().typeCar().primaryColor(chk).secondaryColor(chk).patternDiagonalDualColor().build();
        else if(type==Lang.get("T2")) car=new Car.Builder().typeRacecar().primaryColor(chk).secondaryColor(chk).patternDiagonalDualColor().build();
        else if(type==Lang.get("T3")) car=new Car.Builder().typeTractor().primaryColor(chk).secondaryColor(chk).patternDiagonalDualColor().build();
        else car=new Car.Builder().typeUfo().primaryColor(chk).secondaryColor(chk).patternDiagonalDualColor().build();
        
        //tilføjer spilleren med navn, pengebeholdning og bil
        GUI.addPlayer(this.name,money.getMoney(),car);
        //vi sætter kørertøjet på startfeltet
        GUI.setCar(1,name);
    }
    
    /**
     * Vi opretter en metode som returnere spillerens navn
     * @return navnet 
     */
    public String name(){
        return this.name;
    }
    
    /**
     * vi opretter en metode som returnere positionen
     * @return position 1-40
     */
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int p){
        this.position=p;
    }
    
    public int getPlayer(){
        return this.player;
    }
    /**
     * vi opretter metode til at betale fra en spiller til en anden spiller
     * @param player
     * @param money
     */
    public void pay(Players player,int money){
        this.remove(money);
        player.add(money);
    }
    
    /**
     * Metode som returnerer pengebeholdningen
     * @return penge
     */
    public int getMoney(){
        return this.money.getMoney();
    }
    /**
     * metode som tilføjer penge i brugerens pengebeholdning
     * @param money
     */
    public void add(int money){
        this.money.Add(money);
        GUI.setBalance(this.name,this.getMoney());
    }
    /**
     * Metode som trækker penge fra brugerens pengebeholdning
     * @param money
     */
    public void remove(int money){
        this.money.Substract(money);
        GUI.setBalance(this.name,this.getMoney());
    }
    
    /**
     * metode som returner om spilleren er død
     * @return trule/false
     */
    public boolean dead(){
        return this.money.dead();
    }
    
    /**
     * Vi opretter en metode såóm rykker spillerens position til den nye position
     * @param move
     * @param delay
     */
    public void move(int move,int delay,FieldHandler F) {
        sleep(delay*2);
        for(int i=1;i<=move;i++){
            GUI.removeAllCars(name);
            if(this.position<F.Field.length) GUI.setCar(++this.position,name);
            else{
                position=1;
                GUI.setCar(position,name);
            }
            sleep(delay);
        }
    }
   
    //Metode gør så programmet bliver forsinket en smule
    public void sleep(){
        sleep(1200);
    }
    
    public void sleep(int n){
        long t0, t1;
        t0 = System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while((t1 - t0) < (n));
    }
}
