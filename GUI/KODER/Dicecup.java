package KODER;

public class Dicecup {

    public Dicecup(){
        
    }
    
    private static int t1=0,t2=0;
    
    public int[] Throw(){
        // Aendre tallet '6' efter Math.random() funktionen, til antallet af sider du ønsker terningen skal have.
        
        // Her initialiseres terning 1 og terning 2.
        Dicecup.t1=(int)(Math.random()*6)+1;
        Dicecup.t2=(int)(Math.random()*6)+1;
        int[] K={Dicecup.t1,Dicecup.t2};
        return K;
    }
    
    public int sum(){
        // Terningerne samles i et raflebæger
        return Dicecup.t1+Dicecup.t2;
    }
}


