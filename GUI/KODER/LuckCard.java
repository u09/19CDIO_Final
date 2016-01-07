package KODER;

public class LuckCard {
    //vi opretter variabel til visning af tekst i guien
    private String      text;
    //vi oprretter type så vi ved om der skal rykkes frem/tilbage, betale til banken osv.
    private String      type;
    //Vi opretter værdien som vi skal bruge til at rykke frem/tilbage eller betale beløb osv
    private int         value;
    
    public LuckCard ( String cardType, String cardText, int cardValue){
        type  = cardType;
        text  = cardText;
        value = cardValue;
        
    }
    
    
    
    
    
}
