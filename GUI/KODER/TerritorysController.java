package KODER;

import FieldTypes.Territory;

public class TerritorysController {
<<<<<<< HEAD
    private int[] price;// Definerer et array
    private String col;// Definerer en string
    private FieldHandler F=new FieldHandler();// Opretter objekt af FieldHandler klassen
    private int id;// Definerer en int
=======
    private String col;
    private int id;
>>>>>>> origin/master
    
    /**
     * Kontstruktøren med 2 forskellige parametre
     * @param id
     * @param color
     */
    public TerritorysController(int id,String color){
        // Begge parametre skal blive i denne klasse, hvorfor det er this...
        this.col=color;
        this.id=id;
    }
<<<<<<< HEAD
    
    /**
     * Metode til at returnere et array med numrene på de ens farvede felter, med enten 2 eller 3 værdier
     * @return
=======

    /**
     * 
     * @return Returnerer et array med felter 1-40
>>>>>>> origin/master
     */
    public int[] GetOtherGrounds() {
        // Definerer 4 variabler
        int A=0;
        int B=0;
        int C=0;
        Territory T;
<<<<<<< HEAD
        // Vi looper igennem alle felter på gameboardet
        for(int i=1;i<=40;i++){ 
            if(F.Field[i-1] instanceof Territory){ // Hvis feltet er et territory
                T=(Territory)F.Field[i-1];
                if(T.getColour()==this.col){ // Får fat på et territory felt, og tjekker om det er samme farve som feltet spiller står på
=======
        for(int i=1;i<=40;i++){
            if(FieldHandler.Field[i-1] instanceof Territory){
                T=(Territory)FieldHandler.Field[i-1];
                if(T.getColour()==this.col){
>>>>>>> origin/master
                    if(A==0) A=i;
                    else if(B==0) B=i;
                    else C=i;
                }
            }
        }
        if(C==0) return new int[]{A,B};// Nogen farver har 2 felter, hvilket skal returneres, hvis ikke det sidste felt med samme farve er defineret
        else return new int[]{A,B,C}; // Andre farver har 3 felter, hvilket skal returneres, hvis alle 3 er defineret
    }

    public String getColor() {
        return this.col;
    }

    public int getId() {
        return this.id;
    }
    
<<<<<<< HEAD
    /** Metode til at få en ejer af et felt
     * @param owner
     * @return
     */
    public int getOwner(int owner){
        Ownable O=(Ownable)F.Field[owner];// Kaster arrayet fra FieldHandler ind til at være typen Ownable
        if(O.getOwner()!=null) return O.getOwner().getPlayer();// Hvis der er en ejer af feltet, returnerer den ejeren
        else return -1;// ellers returnerer den -1
=======
    /**
     * @param owner Feltets nummer 0-39
     * @return
     */
    public int getOwner(int owner){
        Ownable O=(Ownable)FieldHandler.Field[owner];
        if(O.getOwner()!=null) return O.getOwner().getPlayer();
        else return -1;
>>>>>>> origin/master
    }
}
