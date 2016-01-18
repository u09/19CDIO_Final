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
        this.type = cardType;
        this.text = cardText;
        this.value = cardValue;
        this.luckFieldNum = 0;
    }
    
    public LuckCard(String type, String text, int value, int luckFieldNum) {
        this.type = type;
        this.text = text;
        this.value = value;
        this.luckFieldNum = luckFieldNum;
    }
    
    public void useCard(Players p) {
        // 3, 8, 18, 23, 34, 37
        System.out.print(text);
        GUI.displayChanceCard(text);
        GUI.getUserButtonPressed("","OK");
        // Betale penge
        if (type == "Pay") p.remove(value);
        // Modtage penge
        else if (type == "Receive") p.add(value);
        // Passerer start
        else {
            GUI.removeCar(p.getPosition(), p.name());
            int n;
            if(p.getPosition()==3) n=1;
            else if(p.getPosition()==8) n=2;
            else if(p.getPosition()==18) n=3;
            else if(p.getPosition()==23) n=4;
            else if(p.getPosition()==34) n=5;
            else n=6;
            
            if(n>=luckFieldNum && luckFieldNum!=0){
                p.setPosition(value);
                GUI.setCar(value, p.name());
                p.add(4000);
            }
            // Flytte 3 felter tilbage. Linje 53 er generelt at flytte 3 tilbage. 
            // Linje 54 er i forhold til at flytte 3 felter tilbage når man lander på første Prøv Lykken.
            else if (type == "MoveBack"){
                p.setPosition(p.getPosition()+value);
                if(p.getPosition()==0) p.setPosition(40);
            }
            // Rykke til fleet
            else if (type == "MoveToShip") {
                if (p.getPosition() < 6 && p.getPosition() > 36) p.setPosition(6);
                else if (p.getPosition() > 6 && p.getPosition() < 16) p.setPosition(16);
                else if (p.getPosition() > 16 && p.getPosition() < 26) p.setPosition(26);
                else p.setPosition(36);
            }
            // Flytte til fængsel
            else if(type=="MoveToJail") p.setPosition(31);
            // Andre andre move kort
            else p.setPosition(value);
            // Rykke i fængsel direkte uden at rykke brikken på brættet.
            if(type=="MoveToJail") GUI.setCar(11,p.name());
            else GUI.setCar(p.getPosition(),p.name());
        }
    }
    
    public boolean getLOF(){
        return (type!="Receive" && type!="Pay");
    }
}
