package KODER;

import FieldTypes.Territory;

public class TerritorysController {
    private String col; // Definerer en string
    private int id; // Definerer en int
    
    /** Kontstruktøren med 2 forskellige parametre
     * @param id
     * @param color
     */
    public TerritorysController(int id,String color){
        // Begge parametre skal blive i denne klasse, hvorfor det er this...
        this.col=color;
        this.id=id;
    }

    /** Metode til at returnere et array med numrene på de ens farvede felter, med enten 2 eller 3 værdier
     * @return Returnerer et array med felter 1-40
     */
    public int[] GetOtherGrounds() {
        // Definerer 4 variabler
        int A=0;
        int B=0;
        int C=0;
        Territory T;
        // Vi looper igennem alle felter i Field array og henter numrene på de felter der har samme farve, som det spilleren er landet på.
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
        // Nogen farver har 2 felter, hvilket skal returneres, hvis ikke det sidste felt med samme farve er defineret
        if(C==0) return new int[]{A,B};
        // Andre farver har 3 felter, hvilket skal returneres, hvis alle 3 er defineret
        else return new int[]{A,B,C};
    }
    public String getColor() {
        return this.col;
    }
    // Bruges ikke
    public int getId() {
        return this.id;
    }
    
    /** Metode til at få en ejer af et felt
     * @param owner Feltets nummer 0-39
     * @return int 0-5, hvis ejes, -1 hvis ikke ejes
     */
    public int getOwner(int owner){
        Ownable O=(Ownable)FieldHandler.Field[owner];
        if(O.getOwner()!=null) return O.getOwner().getPlayer();
        else return -1;
    }
}
