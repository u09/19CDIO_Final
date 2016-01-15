package KODER;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class LuckController{
    private final static Map<String, String> Lang=new Lang().lang("DA");
    public static boolean LOF=false;
    private int cardNum = -1;
    
    public static LuckCard[] LuckCards={
        //Ryk frem/tilbage
        new LuckCard("Move",Lang.get("PrøvLRyk1"),1), 
        new LuckCard("MoveBack", Lang.get("PrøvLRyk2"), -3),
        new LuckCard("Move", Lang.get("PrøvLRyk3"), 25, 5), // Passerer start hvis man lader på Lykke felt nr. 5 eller over. 
        new LuckCard("MoveToJail", Lang.get("PrøvLRyk4"), 11), //3
        new LuckCard("Move", Lang.get("PrøvLRyk5"), 12, 3), // Passerer start hvis man lader på Lykke felt nr. 3 eller over.
        new LuckCard("MoveToShip", Lang.get("PrøvLRyk6"), 0, 6), // Passerer start hvis man lader på Lykke felt nr. 6.
        new LuckCard("Move", Lang.get("PrøvLRyk7"), 40),
        new LuckCard("MoveToJail",Lang.get("PrøvLRyk8"), 11),
        // Betal
        new LuckCard("Pay",Lang.get("PrøvLPay1"),300),
        new LuckCard("Pay",Lang.get("PrøvLPay2"),1000),
        new LuckCard("Pay",Lang.get("PrøvLPay3"),3000),
        new LuckCard("Pay",Lang.get("PrøvLPay4"),3000),
        new LuckCard("Pay",Lang.get("PrøvLPay5"),2000),
        new LuckCard("Pay",Lang.get("PrøvLPay6"),200),
        //new LuckCard("Pardon","I andledning af kongens føldselsdag benådes de fra fængslet",99999),
        //Modtag
        new LuckCard("Receive",Lang.get("PrøvLRec1"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec2"), 500),
        new LuckCard("Receive",Lang.get("PrøvLRec3"), 3000),
        new LuckCard("Receive",Lang.get("PrøvLRec4"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec5"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec6"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec7"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec8"), 200),
        new LuckCard("Receive",Lang.get("PrøvLRec9"), 1000),
        new LuckCard("Receive",Lang.get("PrøvLRec10"), 1000),
        
        
        
        
    };
    
    public LuckController(){
        Collections.shuffle(Arrays.asList(LuckCards));
    }
    
    public void getLuckCard(Players p){
        if(LuckCards.length==cardNum-1) cardNum=-1;
        cardNum++;
        if(LuckCards[cardNum].getLOF()) LOF=true;
        LuckCards[cardNum].useCard(p);
    }
}
