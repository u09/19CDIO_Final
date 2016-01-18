package KODER;

import FieldTypes.Territory;

public class TerritorysController {
    private String col;
    private int id;
    
    public TerritorysController(int id,String color){
        this.col=color;
        this.id=id;
    }

    /**
     * 
     * @return Returnerer et array med felter 1-40
     */
    public int[] GetOtherGrounds() {
        int A=0;
        int B=0;
        int C=0;
        Territory T;
        for(int i=1;i<=40;i++){
            if(FieldHandler.Field[i-1] instanceof Territory){
                T=(Territory)FieldHandler.Field[i-1];
                if(T.getColour()==this.col){
                    if(A==0) A=i;
                    else if(B==0) B=i;
                    else C=i;
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
    
    /**
     * @param owner Feltets nummer 0-39
     * @return
     */
    public int getOwner(int owner){
        Ownable O=(Ownable)FieldHandler.Field[owner];
        if(O.getOwner()!=null) return O.getOwner().getPlayer();
        else return -1;
    }
}
