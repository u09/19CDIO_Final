package KODER;

public class LuckCard {
    private String      text;   //vi opretter variabel til visning af tekst i guien
    private String      type;   //vi oprretter type så vi ved om der skal rykkes frem/tilbage, betale til banken osv.
    private int         value;  //Vi opretter værdien som vi skal bruge til at rykke frem/tilbage eller betale/modtage beløb osv
    
    
    public LuckCard ( String cardType, String cardText, int cardValue){
        type  = cardType;
        text  = cardText;
        value = cardValue;
        
    }
    
    
    
    
    
}
