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
        else dice=new int[][]{{0,0}};
        return dice[i];
    }
}
