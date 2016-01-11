package KODER;

import java.util.Arrays;
import java.util.Map;
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
    private final int TEST=1;
    private final int TEST_PLAYERS=2;
    
    public Controller(){
        PreGame();
        if(this.TEST!=0) this.Test();
        StartGame();
    }
    
    private void Test(){
        this.DELAY=0;
        Test test=new Test();
        if(this.TEST==1) {}//TEST
    }
    
    /**
     * Starter spillet. (While-loopet)
     */
    private void StartGame(){
        int[] D;
        int TI=-1;
        Jail J=(Jail) F.Field[10]; 
        while(true){
            TI++;
            GUI.getUserButtonPressed(this.Lang.get("KT"),"OK");
            
            if(J.isJailed(turn)){
                this.F.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            }
            
            if(this.TEST!=0 && new Test().TestDice(TI,TEST)[0]!=0 && new Test().TestDice(TI,TEST)[1]!=0) D=new Test().TestDice(TI,TEST);
            else if(this.TEST!=0 && (new Test().TestDice(TI,TEST)[0]==0 || new Test().TestDice(TI,TEST)[1]==0)) break;
            else D=Dice.Throw();
            
            if(J.isJailed(turn)){
                if(D[0]!=D[1]){
                    if(J.Nthrows(turn)==3){
                        J.payJail(totalP[turn]);
                    }
                    else{
                        GUI.showMessage("Du har ikke slået 2 ens");
                        GUI.showMessage("Du har ikke sl�et 2 ens");
                        this.CT();
                        continue;
                    }
                }
                else{
                    J.payJail(totalP[turn]);
                    totalP[turn].add(1000);
                }
            }
            
            GUI.setDice(D[0],D[1]);
            totalP[this.turn].move(D[0]+D[1],this.DELAY,F);
            this.F.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            if(totalP[turn].dead()){
                this.DEAD();
            }
            this.CT();
        }
        if(this.TEST!=0) GUI.showMessage(Lang.get("TEST_FAEDIG"));
        else GUI.showMessage(Lang.get("VUNDET")+totalP[turn-1].name()+"!!!!");
        GUI.close();
    }
    
    private void DEAD(){
        /*
        int g=0,n=this.F.getNumOwn(totalP[turn]);
        String[] arrr=this.F.getOwn(totalP[turn]);
        Fields[] Field=new FieldHandler().GetArray();
        if(n>0) for(int i=1;i<=n;i++) g+=(int)(Field[this.con.FieldToNum(arrr[i-1])].price()/2);
        if(g+totalP[turn-1].getMoney()>0) but=GUI.getUserButtonPressed(Lang.get("BANKEROT"),Lang.get("Y"),Lang.get("N"));
        else but=Lang.get("N");
        if(but.equals(Lang.get("Y"))){
            int num=this.con.getNumOwn(turn,ARR);
            String[] ars;
            String sell;
            for(int i=1;i<=num;i++){
                ars=this.con.getOwnSell(turn,ARR);
                sell=GUI.getUserSelection(Lang.get("SAELGEHVAD"),ars);
                for(int asnd=1;asnd<=ars.length;asnd++){
                    if(ars[asnd-1]==sell){
                        sell=this.con.getOwn(turn,ARR)[asnd-1];
                        break;
                    }
                }
//                sell=sell.substring(0,sell.lastIndexOf(" "));
                ARR.put(sell,0);
                this.con.Sell(sell,totalP,turn);
                if(i==num) break;
                if(totalP[turn-1].getMoney()>=0){
                    but=GUI.getUserButtonPressed(Lang.get("FLERE"),Lang.get("Y"),Lang.get("N"));
                    if(but.equals(Lang.get("N"))) break;
                }
            }
            this.con.FixFleet(totalP,ARR);
        }
        else{
            GUI.removeAllCars(totalP[turn-1].name());
            if(this.players-1-this.DeadPlayers==1){
                this.CT();
                break;
            }
            else this.DeadPlayers++;
        }
         */
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
