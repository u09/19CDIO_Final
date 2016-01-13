package Tests;

import java.util.Map;
import KODER.FieldHandler;
import KODER.Players;
import desktop_resources.GUI;

public class Test {
    
    public Test(){
        
    }
    
    public int[] TestDice(int i, int TEST){
        int[][] dice;
        if(TEST==1) dice=new int[][]{{6,4},{5,5},{3,2},{0,0}};
        else if(TEST==2) dice=new int[][]{{1,1},{1,1},{0,0}};
        else if(TEST==3) dice=new int[][]{{1,2},{0,0}};
        else if(TEST==4) dice=new int[][]{{15,15},{21,19},{1,2},{19,21},{1,2},{21,19},{2,2},{21,19},{0,0}};
        else if(TEST==5) dice=new int[][]{{2,3},{2,3},{4,6},{4,6},{0,0}};
        else if(TEST==6) dice=new int[][]{{21,19},{2,1},{2,1},{0,0}};
        //tester om man får penge når man lander på prøv lykken på felt 18, og skal rykke til fr.berg allé(Sæt cardNum til 3)
        else if(TEST==7) dice=new int[][]{{5,12},{2,1},{2,1},{0,0}};
        //tester om de 2 forskellige tax felter har 2 forskellige "effekter"
        else if(TEST==8) dice=new int[][]{{1,3},{20,18},{2,1},{0,0}};
        //tester Labor camp
        else if(TEST==9) dice=new int[][]{{5,7},{5,7},{9,7},{9,7}};
        else dice=new int[][]{{0,0}};
        return dice[i];
    }
}
