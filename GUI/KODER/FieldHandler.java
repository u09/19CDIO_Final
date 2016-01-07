package KODER;

public class FieldHandler{
    public static final Fields[] Field={
        new Starter("Start"),//1
        new Territory("Tribe Encampment",1000,100),
        new Territory("Crater",1500,300),
        new Fleet("Second Sail",4000,500),
        new Refugees("Walled City",5000),//5
        new Territory("Mountain",2000,500),
        new Labor_camp("Huts In The Mountain",2500,100),
        new Territory("Cold Dessert",3000,700),
        new Fleet("Sea Grover",4000,500),
        new Territory("Black Cave",4000,1000),//10
        new Territory("The Werewall",4300,1300),
        new Territory("Mountain Village",4750,1600),
        new Tax("Caravan",4000),
        new Fleet("The Buccanneers",4000,500),
        new Refugees("Monestary",500),//15
        new Territory("South Citadel",5000,2000),
        new Territory("Pallace Gates",5500,2600),
        new Tax("Goldmine",2000),
        new Fleet("Private Armade",4000,500),
        new Territory("Tower",6000,3200),//20
        new Labor_camp("The Pit",2500,100),
        new Territory("Castle",8000,4000),
    };

    public int getNumOwn(Players player){
        int num=0;
        Ownable O;
        for(int i=1;i<=40;i++){
            if(!(Field[i-1] instanceof Ownable)) continue;
            O=(Ownable)Field[i-1];
            if(O.getOwner().name().equals(player.name())) num++;
        }
        return num;
    }

    public String[] getOwn(Players player){
        
        return null;
    }
}
