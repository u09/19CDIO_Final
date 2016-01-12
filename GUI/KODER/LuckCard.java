package KODER;

public class LuckCard {
    private String text;   // variabel til visning af tekst i guien
    private String type;   // type så vi ved om der skal rykkes frem/tilbage,
                           // betale til banken osv.
    private int value;  // værdien som vi skal bruge til at rykke frem/tilbage
                        // eller betale/modtage beløb osv
    private int luckFieldNum; // variabel til at vide om spilleren skal modtage
                              // 4000 kr. ved passering af start
    
    public LuckCard(String cardType, String cardText, int cardValue) {
        type = cardType;
        text = cardText;
        value = cardValue;
    }
    
    public LuckCard(String type, String text, int value, int luckFieldNum) {
        this.type = type;
        this.text = text;
        this.value = value;
        this.luckFieldNum = luckFieldNum;
    }
    
    public void useCard(Players p) {
        // 2, 7, 17, 22, 33, 36
        GUI.displayChanceCard(text);
        GUI.getUserButtonPressed("","OK");
        if (type == "Pay") p.remove(value);
        else if (type == "Receive") p.add(value);
        else {
            GUI.removeCar(p.getPosition(), p.name());
            if (type == "MoveBack"){
                p.setPosition(p.getPosition() + value);
                if(p.getPosition()==0) p.setPosition(40);
            }
            else if (type == "MoveToShip") {
                if (p.getPosition() < 6 && p.getPosition() > 36) p.setPosition(6);
                else if (p.getPosition() > 6 && p.getPosition() < 16) p.setPosition(16);
                else if (p.getPosition() > 16 && p.getPosition() < 26) p.setPosition(26);
                else p.setPosition(36);
            }
            else if(type=="MoveToJail") p.setPosition(31);
            else p.setPosition(value);
            if(type=="MoveToJail") GUI.setCar(11,p.name());
            else GUI.setCar(p.getPosition(),p.name());
        }
    }
    
    public boolean getLOF(){
        return (type!="Receive" && type!="Pay");
    }
}
