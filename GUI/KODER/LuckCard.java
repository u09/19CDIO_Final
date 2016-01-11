package KODER;

public class LuckCard {
    private String text;   // variabel til visning af tekst i guien
    private String type;   // type så vi ved om der skal rykkes frem/tilbage, betale til banken osv.
    private int value;  // værdien som vi skal bruge til at rykke frem/tilbage eller betale/modtage beløb osv
    private int luckFieldNum; // variabel til at vide om spilleren skal modtage 4000 kr. ved passering af start
    
    public LuckCard(String cardType, String cardText, int cardValue) {
        type = cardType;
        text = cardText;
        value = cardValue;
        
    }
    
    public LuckCard(String text, String type, int value, int luckFieldNum) {
        this.text = text;
        this.type = type;
        this.value = value;
        this.luckFieldNum = luckFieldNum;
    }
    
    public void useCard(Players p) {
        // 2, 7, 17, 22, 33, 36
           String pickCard = GUI.getUserButtonPressed("Vil du prøve lykken?", "Ja", "Nej");
            if(pickCard.equals("Ja")) {
                LuckCard card = LuckController.getLuckCard();
                if(card > )
            }
        }
            
        }
