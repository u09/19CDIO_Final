package KODER;

import java.util.Map;
import FieldTypes.Jail;

public abstract class Ownable extends Fields{
    /* Noter til denne klasse:
     * Protected betyder at variablen eller metoden kun kan tilgås fra samme pakke, den samme klasse eller fra en nedarvet klasse.
     * super metoden sender variablen name videre til super klassen hvor den bliver brugt i konstruktøren.
     */
    // Vi definerer en variabel af typen Players, som kan 
    // ses af hele pakken og alle arvede klasser(fra Fields) 
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
        // Vi henter "name" fra de forskellige klasser(felttyper), som extend'er ownable, og giver dem videre til superklassen Fields
        super(name);
        setPrice(price);
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
        // Laver et if-statement, til at køre, hvis et felt ikke er ejet af nogen.
        if(this.owner == null && p.getMoney()-this.price>=0){
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
        else if(this.owner == null && p.getMoney()-this.price<0) GUI.showMessage(Lang.get("IKKE_NOK_PENGE"));
        // Hvis feltet er ejet
        else{
            Jail J = new Jail("");
            // Hvis spilleren som ejer feltet ikke er fængslet
            if(J.isJailed(this.owner.getPlayer())==false){
                // Og hvis nuværende spiller ikke ejer feltet han er landet på
                if(this.owner.name()!=p.name()){
                    // Fjerner prisen på lejen fra spiller
                    GUI.showMessage(Lang.get("BETAL")+getRent(p)+Lang.get("TIL")+p.name());
                    p.remove(getRent(p));
                    // Ejeren af feltet får pengene
                    this.owner.add(getRent(p));   
                }
            }
        }
    }
    
    /**
     * Den abstrakte metode for at få lejen til hvert Ownable felt. 
     * Denne metode specificeres i under hvert felt.
     * @param p Object af Players
     * @return int rent
     */
    public abstract int getRent(Players p);
}
