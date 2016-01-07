package KODER;

public class Fleet extends Ownable{
    private int rent;
    
    public Fleet(String name,int price, int rent){
        super(name,price);
        setRent(rent);
    }
    
    public void FixFleet(){
        FieldHandler F=new FieldHandler();
        Ownable O;
        int num=0;
        for(int i=3;i<=18;i+=5){
            O=(Ownable)F.Field[i];
            System.out.println(O.getOwner().name());
        }
    }
    
    public void PrintFleet(){
        FieldHandler F=new FieldHandler();
        Ownable O;
        int num=0;
        for(int i=3;i<=18;i+=5){
            O=(Ownable)F.Field[i];
            System.out.println(O.getOwner().name());
        }
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        this.rent=rent;
    }
}
