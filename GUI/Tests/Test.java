package Tests;

import KODER.FieldHandler;
import KODER.Ownable;
import KODER.Players;
import desktop_resources.GUI;

public class Test {
    
    public Test(){
        
    }
    
    public int[] TestDice(int i, int TEST){
        int[][] dice;
        //tester besøg i fængslet og køb af mols-linjen???
        if(TEST==1) dice=new int[][]{{6,4},{5,5},{3,2},{0,0}};
        //tester prøv lykken???
        else if(TEST==2) dice=new int[][]{{1,1},{1,1},{0,0}};
        //tester køb af hvidovrevej???
        else if(TEST==3) dice=new int[][]{{1,2},{0,0}};
        //tester Jail
        else if(TEST==4) dice=new int[][]{{15,15},{21,19},{1,2},{19,21},{1,2},{21,19},{2,2},{21,19},{0,0}};
        //tester fleet
        else if(TEST==5) dice=new int[][]{{2,3},{2,3},{4,6},{4,6},{0,0}};
        //tester ???
        else if(TEST==6) dice=new int[][]{{21,19},{2,1},{2,1},{0,0}};
        //tester om man får penge når man lander på prøv lykken på felt 18, og skal rykke til fr.berg allé(Sæt cardNum til 3)
        else if(TEST==7) dice=new int[][]{{5,12},{2,1},{2,1},{0,0}};
        //tester om de 2 forskellige tax felter har 2 forskellige "effekter"
        else if(TEST==8) dice=new int[][]{{1,3},{20,18},{2,1},{0,0}};
        //Tester om man får lejen udbetalt for territory
        else if(TEST==9) dice=new int[][]{{1,2},{1,2},{0,0}};
        //tester Labor camp
        else if(TEST==10) dice=new int[][]{{5,7},{5,7},{9,7},{9,7}};
        // Tester noget
        else if(TEST==11) dice=new int[][]{{20,16},{3,5},{2,1},{0,0}};
        // test til 10% tax
        else if(TEST==12) dice=new int[][]{{20,21},{19,21},{1,1},{20,21},{0,0}};
        else if(TEST==13) dice=new int[][]{{5,4},{5,4},{3,1},{3,1},{0,0}};
        //test til dobbelt leje når man ejer alle grunde med samme farve
        else if(TEST==14) dice=new int[][]{{5,1},{5,1},{0,0}};
        // Tester 3 ens slag til f�ngsel?
        else if(TEST==15) dice=new int [][]{{6,6},{6,6},{6,6},{2,1},{6,2},{2,3},{2,1},{0,0}};
        //Tester om en spiller kan vinde
        else if(TEST==16) dice=new int [][]{{2,2},{2,2},{0,0}};
        //Tester om den resetter luckcards når den når maksimum
        else if(TEST==17) dice=new int [][]{{6,1},{6,1},{6,1},{0,0}};
        else dice=new int[][]{{0,0}};
        return dice[i];
    }

    public void TestSell(Players p){
        p.remove(70000);
        Ownable O;
        for(int i=1;i<=40;i++){
            if(FieldHandler.Field[i-1] instanceof Ownable){
                O=(Ownable)FieldHandler.Field[i-1];
                O.setOwner(p);
                GUI.setOwner(i,p.name());
            }
        }
    }
    
    public void TestGround(Players p){
        Ownable O;
        for(int i=1;i<=40;i++){
            if(FieldHandler.Field[i-1] instanceof Ownable){
                O=(Ownable)FieldHandler.Field[i-1];
                O.setOwner(p);
                GUI.setOwner(i,p.name());
            }
        }
    }

    public void Test16(Players[] p){
        p[0].remove(30000);
        p[1].remove(30000);
    }
}
