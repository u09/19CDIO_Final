package KODER;

public abstract class Fields {
    /* Noter til denne klasse:
     * Abstract kan bruges både til metoder og klasser.
     * Abstract metode er en metode som gælder for alle underklasser men hvor denne metode har forskellige applikationer.
     * Field klassen skal kun retunere navnet på feltet. Hvert felt skal derimod retunere forskellige ting, rent osv.
     * Void = retunere ikke noget.
     * Uden void skal metoden retunerer noget dvs. man skal bruge "return".
     * Uden void og hvis metodens navn er det samme som klassen så er det en konstruktør.
     * En kontruktør opretter en instans af klassen.
     * this. bruges når man gerne vil have den lokale variabel i metoden til at blive sat som den globale variable.
     * De fleste set metoder burde være private, da de plejer at blive ændret gennem konstruktøren.
     */ 
    private String name;
    
    public Fields(String name){
        setName(name);
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    
    /**
     * Den abstrakte landOnField metode, som alle felter deler.
     * @param p Object af Players
     */
    public abstract void landOnField(Players p);
}


