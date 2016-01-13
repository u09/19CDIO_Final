package KODER;

public class TerritorysController {
    private int[] price;
    private boolean[] House={false,false,false,false,false};
    private String col;
    private FieldHandler F=new FieldHandler();
    
    private int id;
    
    public TerritorysController(int id,String color,int[] ar){
        this.col=color;
        this.price=ar;
        this.id=id;
    }
    
    public void BuyH(Players p){
        boolean check=CheckOtherGrounds(p);
    }

    private boolean CheckOtherGrounds(Players p) {
        int[] arr=GetOtherGrounds();
        int n=getNumH(2);
        for(int i=1;i<=arr.length;i++){
            
        }
        return false;
    }

    private int getNumH(int id) {
        int n=0;
        Territory T=(Territory)F.Field[id];
        T.GetHouse();
        for(int i=1;i<=T.GetHouse().length;i++) if(T.GetHouse()[i-1]==true) n++;
        return n;
    }

    public int[] GetOtherGrounds() {
        int A=0;
        int B=0;
        int C=0;
        Territory T;
        for(int i=1;i<=40;i++){
            if(F.Field[i-1] instanceof Territory){
                T=(Territory)F.Field[i-1];
                if(T.getColour()==this.col){
                    if(A==0) A=T.getId();
                    else if(B==0) B=T.getId();
                    else C=T.getId();
                }
            }
        }
        if(C==0) return new int[]{A,B};
        else return new int[]{A,B,C};
    }

    public String getColor() {
        return this.col;
    }

    public int getId() {
        return this.id;
    }
    
    public int getOwner(int owner){
        
        Ownable O=(Ownable)F.Field[owner];
        return O.getOwner().getPlayer();
    }
    
    public boolean[] giveHouses() {
        return this.House;
    }
}
