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
        // 3, 8, 18, 23, 34, 37
        GUI.displayChanceCard(text);
        GUI.getUserButtonPressed("","OK");
        if (type == "Pay") p.remove(value);
        else if (type == "Receive") p.add(value);
        else {
            GUI.removeCar(p.getPosition(), p.name());
            int n;
            if(p.getPosition()==3) n=1;
            else if(p.getPosition()==8) n=2;
            else if(p.getPosition()==18) n=3;
            else if(p.getPosition()==23) n=4;
            else if(p.getPosition()==34) n=5;
            else n=6;
            
            if(n>=luckFieldNum){
                p.setPosition(value);
                GUI.setCar(value, p.name());
                p.add(4000);
            }
            else if (type == "MoveBack"){
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
