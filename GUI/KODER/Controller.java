package KODER;

public class Controller{
    public Controller(){
        FieldHandler F=new FieldHandler();
        if(F.Field[1] instanceof Ownable)
        {
            Ownable O=(Ownable)F.Field[1];
            System.out.println(O.getRent());
        }
    }
}
