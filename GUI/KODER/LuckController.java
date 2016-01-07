package KODER;

public class LuckController {
    
        public static LuckCard[] LuckCards = {
            
            //Ryk frem/tilbage
            new LuckCard("MoveBack", "Ryk tre felter tilbage brow", -3),
            
            // Betal 
            
            new LuckCard("Pay","Du har købt ØL derfor skal du betale 300KR til banken",300),
            new LuckCard("Pay","De har kørt frem for FULD STOP. Betal 1000KR i bøde",1000),
            new LuckCard("Pay","Betal 3000kr for reparation af deres vogn",3000),
            new LuckCard("Pay","Betal 3000kr for reparation af deres vogn",3000),
            new LuckCard("Pay","De har modtaget deres tandlæge regning. Betal 2000kr",2000),
            new LuckCard("Pay","De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal 200kr i told",200),
            //new LuckCard("Pardon","I andledning af kongens føldselsdag benådes de fra fængslet",200),

            //
            //Modtag
            new LuckCard("","",1),
            new LuckCard("","",1),
            new LuckCard("","",1),
            new LuckCard("","",1),
            new LuckCard("","",1),
            new LuckCard("","",1),
            
        };
    
}
