package KODER;

public class Tax extends Fields{ // forlænger klasse med en anden klasse
    private int tax;
    private int taxRate=10;
    
    public Tax(String name, int tax){ // Konstruktør til at sætte fæltnavn og lejen
        super(name);
        this.tax=tax;
    }
    
    @Override
    public void landOnField(Players player){
        if(player.getPosition()==38) this.tax=2000;
        else{
            String b = GUI.getUserButtonPressed("Vil du betale 4000 eller 10%", "Betal 4000", "Betal 10%");
            if(b=="Betal 4000") this.tax=4000;
            else{
                FieldHandler f= new FieldHandler();
                int EjendomSum = 0; 
                Ownable O;
                for(int i = 0; i<f.Field.length; i++){
                    if(f.Field[i] instanceof Ownable){
                        O=(Ownable) f.Field[i];
                        if(O.getOwner().name()==player.name()) EjendomSum+=O.getPrice();
                    }
                }
                this.tax=(player.getMoney()+EjendomSum)/this.taxRate;
            }
        }
        player.remove(this.tax);
    }
}
