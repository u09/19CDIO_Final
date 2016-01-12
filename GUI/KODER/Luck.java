package KODER;
public class Luck extends Fields {
    private static LuckController LuckConObj;
    
    public Luck(String name){
        super(name);
        LuckConObj=new LuckController();
    }
    
    @Override
    public void landOnField(Players p){
        String pickCard = GUI.getUserButtonPressed("Vil du prøve lykken?", "Ja", "Nej");
        if(pickCard=="Ja") LuckConObj.getLuckCard(p);
    }
}
