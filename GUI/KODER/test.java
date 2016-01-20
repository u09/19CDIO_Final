package KODER;

import java.util.Map;

public class test {
    private static Players p;
    private static int i;
    private final static Map<String, String> Lang=new Lang().lang("DA");
    private static int[] i2;
    
    public static void main(String[] args){
        p=new Players("test",Lang.get("F1"),Lang.get("T1"),Lang,0);
        System.out.println(p.getMoney());
        test(p);
        System.out.println(p.getMoney());
        
        i=10;
        System.out.println(i);
        test2(i);
        System.out.println(i);
        
        i2=new int[]{1,1};
        System.out.println(i2[0]+","+i2[1]);
        test3(i2);
        System.out.println(i2[0]+","+i2[1]);
    }
    
    public static void test(Players p){
        p.add(1000);
    }
    
    public static void test2(int i){
        i=20;
    }
    
    private static void test3(int[] i2) {
        i2[0]=2;
        i2[1]=2;
    }
}
