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
        else dice=new int[][]{{0,0}};
        return dice[i];
    }
}
