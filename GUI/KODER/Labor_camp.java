package KODER;

public class Labor_camp extends Ownable{
    private int rent;
    
    public Labor_camp(String name,int price,int rent){
        super(name,price);
        setRent(rent);
    }
    
    @Override
    public int getRent(){
        return this.rent;
    }
    
    private void setRent(int rent){
        Dicecup D = new Dicecup();
        D.Throw();
        int s = D.sum();
        this.rent=rent;
<<<<<<< Updated upstream
        FieldHandler f = new FieldHandler();
        Ownable O = (Ownable) f.Field[12];
        Ownable O2 = (Ownable) f.Field[28];
        if(O.getOwner().name()==O2.getOwner().name()){
            this.rent = s*rent*2;
            
        }
=======
        FieldHandler f=new FieldHandler();
        Dicecup D = new Dicecup();
        D.Throw();
        int sum = D.sum();
        Ownable O = (Ownable) f.Field[12];
        Ownable O2 = (Ownable) f.Field[28];
        if(O.getOwner().name()==O2.getOwner().name()){
            
            this.rent=sum*rent*2;
            
        }
        else if(O.getOwner().name() != O2.getOwner().name()){
            
            this.rent=sum*rent;
            
        }
        else if(O.getOwner().name()==null || O2.getOwner().name()==null){
            this.rent=0;
           /* String V = GUI.getUserButtonPressed("Vil du købe grunden til 3000?", "Ja","Nej"){
                if(V=="Ja"){
                    
                    
                }
                else if(V=="Nej"){
                    continue;
                }
                
            }*/
        }
        
    }

    public void landOnField(Players player) {
        
>>>>>>> Stashed changes
    }
}
