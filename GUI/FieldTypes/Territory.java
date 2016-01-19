package FieldTypes;

import KODER.Ownable;
import KODER.Players;
import KODER.TerritorysController;

public class Territory extends Ownable {
    /* Noter til denne klasse:
     * getOwnedBy metoden kører igennem alle de veje med den samme farve og tjekker
     * 
     */ 
    //Definerer 2 forskellige variabler, med typerne int og TerritorysController
    private int rent;
    private TerritorysController TC;
    
    // Konstruktør med 5 forskellige parametre
    public Territory(int id, String name, String Colour, int price, int rent) {
        super(name, price); // giver navnet og prisen videre til superklassen Ownable fra Fieldhandler klassen, hvor vi har arrayet
        this.rent = rent; // Henter lejen fra de arrayet, og sørger for den kun bliver herinde
        TC = new TerritorysController(id, Colour); // Opretter objekt af TerritorysController
    }
    
    @Override
    public int getRent(Players p){
        return (getOwnedBy()?rent*2:rent);
    }
    
    public String getColour(){
        return TC.getColor();
    }
    
    public int getId() {
        return TC.getId();
    }
    /**
     * Metode som returnerer en boolean, som tjekker om felter af samme farve er ejet af en eller flere spiller, 
     * ud fra feltet nuværende spiller er landet på
    */
    public boolean getOwnedBy(){
        boolean colorsOwned=true;
        int[] sameColor=TC.GetOtherGrounds(); // Vi laver et array, med numrene på de ens farvede felter, med enten 2 eller 3 værdier
        // For loop som løber igennem sameColor og tjekker om ejeren af et felt, også er ejeren af de andre af samme farve. Hvis ikke man ejer alle felter af samme farve, bliver colorsOwned false 
        for(int i=1;i<=sameColor.length;i++) if(TC.getOwner(sameColor[i-1]-1)!=this.owner.getPlayer()) colorsOwned=false;
        return colorsOwned;
    }
}
