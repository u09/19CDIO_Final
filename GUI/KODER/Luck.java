package KODER;
public class Luck extends Fields {
    
    LuckCard LuckConObj;
    
    public Luck(String name){
        super(name);
        LuckConObj=new LuckController().getLuckCard();
    }

    
    @Override
    public void landOnField(Players p) {
       LuckConObj.useCard(p);
    }

}
