package KODER;

public class Tax extends Fields{ // forlænger klasse med en anden klasse
    private int tax;
    private int taxRate=10;
    
    public Tax(String name, int tax){ // Konstruktør til at sætte fæltnavn og lejen
        super(name);
        setName(name);
        this.tax=tax;
    }
    
    @Override
    public void landOnField(Players player){
        
    }
}
