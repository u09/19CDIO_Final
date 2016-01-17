package KODER;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import FieldTypes.Jail;
import desktop_resources.GUI;
import Tests.Test;

public class Controller{
    private int DeadPlayers = 0;
    private int players; // Initialisere
    private int turn=0; // Hvis tur det er
    private Players[] totalP;// Total antal spillere
    public static Dicecup Dice=new Dicecup(); // Initialisere objekt
    private final Map<String, String> Lang=new Lang().lang("DA");// Initiallisere objekt
    private GameBoard Board=new GameBoard(); // initiallisere objekt
    private FieldHandler F=new FieldHandler(); // Opretter et nyt objkekt
    private int DELAY=600;
    private String[] colors={Lang.get("F1"),Lang.get("F2"),Lang.get("F3"),Lang.get("F4"),Lang.get("F5"),Lang.get("F6")};
    private final int TEST=12;
    private final int TEST_PLAYERS=2;
    private boolean firstR=true;
    
    public Controller(){
        PreGame();
        if(this.TEST!=0) this.Test();
        StartGame();
    }
    
    private void Test(){
        this.DELAY=0;
        Test test=new Test();
        if(this.TEST==12) test.TestSell(totalP[turn],F);
        else if(this.TEST==14) test.TestGround(totalP[0],F);

    }
  
    /**
     * Starter spillet. (While-loopet)
     */
    private void StartGame(){
        boolean CheckJail=false;
        int[] D;
        int TI=-1;
        int ens=0;
        LuckController LC=new LuckController();
        Jail J=(Jail) F.Field[10];
        while(true){
            TI++;
            GUI.getUserButtonPressed(this.Lang.get("KT"),"OK");
            
            if(J.isJailed(turn)) this.F.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            if(this.TEST!=0 && new Test().TestDice(TI,TEST)[0]!=0 && new Test().TestDice(TI,TEST)[1]!=0) D=new Test().TestDice(TI,TEST);
            else if(this.TEST!=0 && (new Test().TestDice(TI,TEST)[0]==0 && new Test().TestDice(TI,TEST)[1]==0)) break;
            else D=Dice.Throw();
            GUI.setDice(D[0],D[1]);
            System.out.print("Spiller"+(turn+1)+" slog {"+D[0]+";"+D[1]+"}");
            
            if(D[0]==D[1] && ens==2){
                ens=0;
                MoveToJail(totalP[turn]);
                continue;
            }
            
            if(J.isJailed(turn)){
                if(D[0]!=D[1]){
                    if(J.Nthrows(turn)==3) J.payJail(totalP[turn]);
                    else{
                        GUI.showMessage(Lang.get("Ikke2ens"));
                        this.CT();
                        continue;
                    }
                }
                else{
                    J.payJail(totalP[turn]);
                    totalP[turn].add(1000);
                    CheckJail=true;
                }
            }
            
            totalP[this.turn].move(D[0]+D[1],this.DELAY,F);
            
            CheckMoneyStart(totalP[turn],D);
            
            this.F.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            if(LC.LOF){
                LC.LOF=false;
                this.F.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            }
            if((D[0]!=D[1] && !totalP[turn].dead()) || (J.Nthrows(turn)==0 && J.isJailed(turn)) || CheckJail){
                this.CT();
                ens=0;
                CheckJail=false;
            }
            if(totalP[turn].dead()){
                this.DEAD();
                if(totalP[turn].dead()){
                    ens=0;
                    this.CT();
                }
            }
            else ens++;
            if(TI==this.players-1) firstR=false;
            System.out.println();
        }
        if(this.TEST!=0) GUI.showMessage(Lang.get("TEST_FAEDIG"));
        else GUI.showMessage(Lang.get("VUNDET")+totalP[turn-1].name()+"!!!!");
        GUI.close();
    }
    
    private void CheckMoneyStart(Players p,int[] D) {
        
        int f =p.getPosition()-(D[0]+D[1]);
        if(f<=1 && p.getPosition()!=1 && firstR==false){
            p.add(4000);
            
        }
    }
    
    private void MoveToJail(Players p){
        GUI.removeCar(p.getPosition(),p.name());
        GUI.setCar(11,p.name());
        p.setPosition(31);
        this.F.Field[p.getPosition()-1].landOnField(p);
    }
    
    private void printArr(int[] arr){
        System.out.println("Array");
        System.out.println("[");
        for(int i=1;i<=arr.length;i++) System.out.println("\t"+(i-1)+" : "+arr[i-1]+",");
        System.out.println("]");
    }
    
    private void printArr(String[] arr){
        System.out.println("Array");
        System.out.println("[");
        for(int i=1;i<=arr.length;i++) System.out.println("\t"+(i-1)+" : "+arr[i-1]+",");
        System.out.println("]");
    }
    
    private void DEAD(){
        Ownable O;
        String sell;
        int p=0;
        int[] n=F.getOwn(totalP[turn]);
        for(int i=1;i<=n.length;i++){
            O=(Ownable)F.Field[n[i-1]-1];
            p+=O.getPrice()/2;
        }
        
        if(totalP[turn].getMoney()+p<0){
            for(int i=1;i<=n.length;i++){
                O=(Ownable)F.Field[n[i-1]-1];
                O.setOwner(null);
                GUI.removeOwner(n[i-1]);
            }
            GUI.removeAllCars(totalP[turn].name());
        }
        else{
            String[] ar;
            String name;
            int id;
            String check="";
            while(true){
                n=F.getOwn(totalP[turn]);
                ar=new String[n.length];
                for(int i=1;i<=n.length;i++){
                    O=(Ownable)F.Field[n[i-1]-1];
                    ar[i-1]=O.getName()+" ("+O.getPrice()/2+")";
                }
                sell=GUI.getUserSelection(Lang.get("SAELGEHVAD"),ar);
                if(sell.substring(sell.length()-7,sell.length()-6).equals(" ")) name=sell.substring(0,sell.length()-7);
                else name=sell.substring(0,sell.length()-6);
                id=F.nameToNum(name);
                O=(Ownable)F.Field[id-1];
                O.setOwner(null);
                GUI.removeOwner(id);
                totalP[turn].add(O.getPrice()/2);
                if(totalP[turn].getMoney()>=0 && n.length>1) check=GUI.getUserButtonPressed(Lang.get("FLERE"),Lang.get("Y"),Lang.get("N"));
                if(check.equals(Lang.get("N")) || n.length==1) break;
            }
        }
        
        
    }
    
    /**
     * Returnerer positionen af den aktuelle spillers position
     * @return 1-22
     */
    private int position(){
        return totalP[this.turn].getPosition();
    }
    
    /**
     * Skifter spillerens tur. Spinger dead spillere over
     */
    private void CT(){
        if(this.turn==this.players-1) this.turn=0;
        else this.turn++;
        if(this.totalP[turn].dead()) CT();
    }
    
    /**
     * Tilfoejer spillere til boardet (navn,penge,farve,type)
     */
    private void AddPlayers(){
        boolean check=true;
        String name;
        String col;
        
        for(int i=1;i<=this.players;i++){
            if(check) name=GUI.getUserString(Lang.get("NAME")+i);
            else name=GUI.getUserString(Lang.get("NAME2")+i);
            check=true;
            if(i>1){
                first:
                    for(int t=1;t<=i-1;t++){
                        if(totalP[t-1].name().equals(name)){
                            i--;
                            check=false;
                            break first;
                        }
                    }
            }
            if(!check) continue;
            col=GUI.getUserSelection(this.Lang.get("Chose_Color"),this.colors);
            this.colors=removeElement(this.colors,Arrays.asList(this.colors).indexOf(col));
            totalP[i-1]=new Players(name,col,
                GUI.getUserSelection(this.Lang.get("Chose_Type"),
                    this.Lang.get("T1"),
                    this.Lang.get("T2"),
                    this.Lang.get("T3"),
                    this.Lang.get("T4")),
                Lang,i-1);
        }
    }
    
    /**
     * Fjerner element fra array
     * @param original = Array'et der skal fjernes fra
     * @param element = Hvilket element der skal fjernes
     * @return Returnerer et array med det fjernet element
     */
    public String[] removeElement(String[] original, int element){
        String[] n = new String[original.length - 1];
        System.arraycopy(original, 0, n, 0, element );
        System.arraycopy(original, element+1, n, element, original.length - element-1);
        return n;
    }
    
    /**
     * Sætter subtexten for GUI'en
     */
    private void setLang(){
        for(int i=1;i<=41;i++) GUI.setSubText(i,"");
        for(int i=1;i<=40;i++) GUI.setSubText(i,"");
    }
    
    /**
     * Sætter sproget for boardet og antal spillere
     */
    private void PreGame(){
        this.Board.createBoard(this.Lang);
        //        this.setLang();
        if(this.TEST==0)
        {
            this.players=Integer.parseInt(GUI.getUserSelection(this.Lang.get("AS2"),"2","3","4","5","6"));
            this.totalP=new Players[this.players];
            this.AddPlayers();
        }
        else
        {
            String[][] str={
                {"Test1",this.Lang.get("F1"),this.Lang.get("T1")},
                {"Test2",this.Lang.get("F2"),this.Lang.get("T1")},
                {"Test3",this.Lang.get("F3"),this.Lang.get("T1")},
                {"Test4",this.Lang.get("F4"),this.Lang.get("T1")},
                {"Test5",this.Lang.get("F5"),this.Lang.get("T1")},
                {"Test6",this.Lang.get("F6"),this.Lang.get("T1")}
            };
            this.players=this.TEST_PLAYERS;
            this.totalP=new Players[this.players];
            
            for(int i=0;i<=this.players-1;i++) totalP[i]=new Players(str[i][0],str[i][1],str[i][2],Lang,i);
        }
    }
    
}
