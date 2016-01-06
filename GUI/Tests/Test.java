package Tests;

import java.util.Map;
import KODER.FieldHandler;
import KODER.Players;
import desktop_resources.GUI;

public class Test {
    
    public Test(){
        
    }
    
    public void TestFleet(Players[] totalP, Map<String, Integer> ARR, int turn, FieldHandler con){
        totalP[0].remove(30000);
        String[] n={"Second Sail","Sea Grover","The Buccanneers"};
        int i=-1;
        for(int z=4;z<=14;z+=5)
        {
            i++;
            ARR.put(n[i],turn);
            GUI.setOwner(z,totalP[0].name());
        }
        con.FixFleet(totalP,ARR);
    }
    
    public int[] TestDice(int i, int TEST){
        int[][] dice;
        if(TEST==1) dice=new int[][]{{2,1},{2,1},{4,5},{3,2},{0,0}};
        else if(TEST==2) dice=new int[][]{{6,6},{0,0}};
        else if(TEST==3) dice=new int[][]{{5,5},{5,5},{0,0}};
        else dice=new int[][]{{0,0}};
        return dice[i];
    }

    public void TestCaravan(Players[] totalP, Map<String, Integer> ARR, int turn, FieldHandler con) {
        totalP[0].remove(20000);
        String[] n={"Second Sail","Sea Grover","The Buccanneers"};
        int i=-1;
        for(int z=4;z<=14;z+=5)
        {
            i++;
            ARR.put(n[i],turn);
            GUI.setOwner(z,totalP[0].name());
        }
        con.FixFleet(totalP,ARR);
    }
}
