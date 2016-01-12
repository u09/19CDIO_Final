package KODER;

import java.util.Arrays;
import java.util.Collections;

public class LuckController{
    
    public static boolean LOF=false;
    private int cardNum = -1;
    public static LuckCard[] LuckCards={
        //Ryk frem/tilbage
        new LuckCard("Move", "Ryk frem til START", 1),
        new LuckCard("MoveBack", "Ryk tre felter tilbage", -3),
        new LuckCard("Move", "Ryk frem til Grønningen. Hvis De passerer START, indkasser da KR.4000.", 25, 5), // Passerer start hvis man lader på Lykke felt nr. 5 eller over. 
        new LuckCard("MoveToJail", "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.", 11), //3
        new LuckCard("Move", "Ryk frem til Frederiksberg Allé. Hvis De passerer START indkasser KR. 4000.", 12, 3), // Passerer start hvis man lader på Lykke felt nr. 3 eller over.
        new LuckCard("MoveToShip", "Tag med den nærmeste færge - Flyt brikken frem, og hvis De passerer START indkasser da KR. 4000.", 0, 6), // Passerer start hvis man lader på Lykke felt nr. 6.
        new LuckCard("Move", "Tag ind på Rådhuspladsen.", 40),
        new LuckCard("MoveToJail", "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.", 11),
        // Betal
        new LuckCard("Pay","Du har købt ØL derfor skal du betale 300KR til banken",300),
        new LuckCard("Pay","De har kørt frem for FULD STOP. Betal 1000KR i bøde",1000),
        new LuckCard("Pay","Betal 3000KR for reparation af deres vogn",3000),
        new LuckCard("Pay","Betal 3000KR for reparation af deres vogn",3000),
        new LuckCard("Pay","De har modtaget deres tandlæge regning. Betal 2000KR",2000),
        new LuckCard("Pay","De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal 200KR i told",200),
        //new LuckCard("Pardon","I andledning af kongens føldselsdag benådes de fra fængslet",99999),
        //Modtag
        new LuckCard("Receive","Grundet dyrtiden har De fået gangeforhøjelse. Modtag 1000KR", 1000),
        new LuckCard("Receive","De har vundet i Klasselotteriet. Modtag  500 KR.", 500),
        new LuckCard("Receive","Kommunen har eftergivet et kvartals. Hæv i banken 3000KR", 3000),
        new LuckCard("Receive","De modtager Derers aktieudbytte. Modtag 1000 KR af banken.", 1000),
        new LuckCard("Receive","Deres præmieobligation er kommet ud. De modtager 1000 KR af banken.", 1000),
        new LuckCard("Receive","Modtag udbytte af Deres aktier 1000 KR", 1000),
        new LuckCard("Receive","De havde enrække med elleve rigtige i tipning. Modtag 1000 KR.", 1000),
        new LuckCard("Receive","Værdien af egen avl fra nyttehaven udgør 200 KR, som De modtager af banken", 200),
        new LuckCard("Receive","Modtag udbytte af Deres aktier 1000 KR.", 1000),
        new LuckCard("Receive","Deres præmieobligation er kommet ud. De modtager 1000KR. af banken", 1000)
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
