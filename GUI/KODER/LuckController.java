package KODER;

public class LuckController {
    
        public static LuckCard[] LuckCards = {
            
            //Ryk frem/tilbage
            new LuckCard( "Move", "Ryk frem til START", 1), //0
            new LuckCard( "MoveBack", "Ryk tre felter tilbage", -3),//1 
            new LuckCard( "Move", "Ryk frem til Grønningen. Hvis De passerer START, indkasser da KR.4000.", 25),//2
            new LuckCard( "MoveToJail", "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.", 11),//3
            new LuckCard( "Move", "Ryk frem til Frederiksberg Allé. Hvis De passerer START indkasser KR. 4000.", 11),//4
            new LuckCard( "MoveToShip", "Tag med den nærmeste færge - Flyt brikken frem, og hvis De passerer START indkasser da KR. 4000.", 0),
            new LuckCard( "Move", "Tag ind på Rådhuspladsen.", 40),//6
            new LuckCard( "MoveToJail", "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.", 11),
            
            
            // Betal 
            
            new LuckCard("Pay","Du har købt ØL derfor skal du betale 300KR til banken",300),//8
            new LuckCard("Pay","De har kørt frem for FULD STOP. Betal 1000KR i bøde",1000),
            new LuckCard("Pay","Betal 3000KR for reparation af deres vogn",3000),//10
            new LuckCard("Pay","Betal 3000KR for reparation af deres vogn",3000),
            new LuckCard("Pay","De har modtaget deres tandlæge regning. Betal 2000KR",2000),//12
            new LuckCard("Pay","De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal 200KR i told",200),
            //new LuckCard("Pardon","I andledning af kongens føldselsdag benådes de fra fængslet",99999),

            //Modtag
            new LuckCard("Receive","Grundet dyrtiden har De fået gangeforhøjelse. Modtag 1000KR", 1000),//14
            new LuckCard("Receive","De har vundet i Klasselotteriet. Modtag  500 KR.", 500),
            new LuckCard("Receive","Kommunen har eftergivet et kvartals. Hæv i banken 3000KR", 3000),//16
            new LuckCard("Receive","De modtager Derers aktieudbytte. Modtag 1000 KR af banken.", 1000),
            new LuckCard("Receive","Deres præmieobligation er kommet ud. De modtager 1000 KR af banken.", 1000),//18
            new LuckCard("Receive","Modtag udbytte af Deres aktier 1000 KR", 1000),
            new LuckCard("Receive","De havde enrække med elleve rigtige i tipning. Modtag 1000 KR.", 1000),//20
            new LuckCard("Receive","Værdien af egen avl fra nyttehaven udgør 200 KR, som De modtager af banken", 200),
            new LuckCard("Receive","Modtag udbytte af Deres aktier 1000 KR.", 1000),//22
            new LuckCard("Receive","Deres præmieobligation er kommet ud. De modtager 1000KR. af banken", 1000),
            
        };
        
        
        public static LuckCard getLuckCard(){
            
            return null;
            
            
            

        }
    
}
