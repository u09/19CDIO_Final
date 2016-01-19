package KODER;

import java.util.Map;
import FieldTypes.Jail;

public abstract class Ownable extends Fields {
<<<<<<< HEAD
    // Vi definerer en variabel af typen Players, som kan ses af hele pakken og alle arvede klasser(fra Fields) 
=======
    /* Noter til denne klasse:
     * Protected betyder at variablen eller metoden kun kan tilgås fra den samme klasse eller fra en nedarvet klasse.
     * super metoden sender variablen name videre til super klassen hvor den bliver brugt i konstruktøren.
     * 
     */ 
>>>>>>> origin/master
    protected Players owner;
    // Definerer ny int variabel
    private int price;
    // Henter hashmap fra klassen Lang
    private final Map<String, String> Lang=new Lang().lang("DA");
    
    /** Konstruktøren med 2 parametere
     * @param name
     * @param price
     */
    public Ownable(String name,int price){
        // vi henter "name" fra de forskellige klasser(felttyper), som extend'er ownable, og giver dem videre til superklassen Fields
        super(name);
<<<<<<< HEAD
        // vi henter prisen fra de forskellige klasser(felttyper), som extend'er ownable. De skal blive her og ikke videre
        this.setPrice(price);
=======
        setPrice(price);
>>>>>>> origin/master
    }
    
    public Players getOwner() {
        return owner;
    }
     
    public void setOwner(Players owner){
        this.owner = owner;
    }
    
    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public void landOnField(Players p) {
<<<<<<< HEAD
        // Laver et if-statement, til at køre, hvis et felt ikke er ejet af nogen.
        if(this.owner == null){
=======
        if(this.owner == null && p.getMoney()-this.price>=0){
>>>>>>> origin/master
            String k = GUI.getUserButtonPressed(Lang.get("KG"), Lang.get("Y") , Lang.get("N"));
            // Hvis man vælger at købe det
            if(k==Lang.get("Y")){
                // vi sætter ejeren til at være spilleren i øjeblikket 
                this.owner=p;
                // Vi sætter pågældende spiller til at eje feltet på GUI'en
                GUI.setOwner(p.getPosition(),p.name());
                // Beløbet for feltet skal fjernes fra spillerens pengebeholdning
                p.remove(getPrice());
            }
        }
<<<<<<< HEAD
        // Hvis feltet er ejet
        else{
            Jail J = new Jail(p.name());
            // Hvis spilleren som ejer feltet ikke er fængslet
=======
        else if(this.owner == null && p.getMoney()-this.price<0) GUI.showMessage(Lang.get("IKKE_NOK_PENGE"));
        else{
            Jail J = new Jail("");
>>>>>>> origin/master
            if(J.isJailed(this.owner.getPlayer())==false){
                // Og hvis nuværende spiller ikke ejer feltet han er landet på
                if(this.owner.name()!=p.name()){
<<<<<<< HEAD
                    // Viser på GUI
                    GUI.showMessage(Lang.get("BETAL"));
                    // Fjerner prisen på lejen fra spiller
=======
                    GUI.showMessage(Lang.get("BETAL")+getRent(p)+Lang.get("TIL")+p.name());
>>>>>>> origin/master
                    p.remove(getRent(p));
                    // Ejeren af feltet får pengene
                    this.owner.add(getRent(p));   
                }
            }
        }
            
    }
    
<<<<<<< HEAD
    /** laver en abstract metode, så alle de forskellige ownable klasser(felttyper), selv kan bestemme lejen
     * @param p
=======
    /**
     * Den abstrakte metode for at få lejen til hvert Ownable felt. Denne metode specificeres i under hvert felt.
     * @param p Object af Players
     * @return
>>>>>>> origin/master
     */
    public abstract int getRent(Players p);
}