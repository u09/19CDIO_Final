package KODER;

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
    private int DELAY=0;
    private String[] colors={Lang.get("F1"),Lang.get("F2"),Lang.get("F3"),Lang.get("F4"),Lang.get("F5"),Lang.get("F6")};
    private String[] type={Lang.get("T1"),Lang.get("T2"),Lang.get("T3"),Lang.get("T4")};
    private final int TEST=14;
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
        if(this.TEST==12) test.TestSell(totalP[turn]);
        else if(this.TEST==14) test.TestGround(totalP[0]);
        else if(this.TEST==16) test.Test16(totalP);
    }
  
    /**
     * Starter spillet. (While-loopet)
     */
    private void StartGame(){
        boolean CheckJail=false;
        int[] D;
        int TI=-1;
        int ens=0;
        Jail J=(Jail) FieldHandler.Field[10];
        while(true){
            TI++;
            GUI.getUserButtonPressed(this.Lang.get("KT")+totalP[turn].name(),"OK");
            
            if(J.isJailed(turn)) FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            if(this.TEST!=0 && new Test().TestDice(TI,TEST)[0]!=0 && new Test().TestDice(TI,TEST)[1]!=0) D=new Test().TestDice(TI,TEST);
            else if(this.TEST!=0 && (new Test().TestDice(TI,TEST)[0]==0 && new Test().TestDice(TI,TEST)[1]==0)) break;
            else D=Dice.Throw();
            GUI.setDice(D[0],D[1]);
            System.out.print("Spiller"+(turn+1)+" slog {"+D[0]+";"+D[1]+"}"+" ("+totalP[turn].getPosition()+"->"+((D[0]+D[1]+totalP[turn].getPosition())%40)+")\t\t");
            
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
            
            totalP[this.turn].move(D[0]+D[1],this.DELAY);
            
            CheckMoneyStart(totalP[turn],D);
            
            FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            if(LuckController.LOF){
                LuckController.LOF=false;
                FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            }
            /* Første betingelse er hvis han ikke slår to ens og ikke er død. 
             * Anden mulig betingelse er hvis han er i fængsel og har ikke slået med terningerne dvs. han er lige kommet ind i jail.
             * Trejde mulig betingelse er CheckJail som er true når han lige er kommet ud af fængslet dvs. han skal ikke slå igen.
             */
            if((D[0]!=D[1] && !totalP[turn].dead()) || (J.Nthrows(turn)==0 && J.isJailed(turn)) || CheckJail){
                this.CT();
                ens=0;
                CheckJail=false;
            }
            else if(totalP[turn].dead()){
                this.DEAD();
                if(totalP[turn].dead()){
                    ens=0;
                    this.CT();
                    if(CheckWin()) break;
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
    
    private boolean CheckWin(){
        if(this.players-this.DeadPlayers==1) return true;
        return false;
    }

    private void CheckMoneyStart(Players p,int[] D){
        int f =p.getPosition()-(D[0]+D[1]);
        if(f<=1 && p.getPosition()!=1 && firstR==false) p.add(4000);
    }
    
    private void MoveToJail(Players p){
        GUI.removeCar(p.getPosition(),p.name());
        GUI.setCar(11,p.name());
        p.setPosition(31);
        FieldHandler.Field[p.getPosition()-1].landOnField(p);
    }
    
    private void DEAD(){
        Ownable O;
        String sell;
        int p=0;
        int[] n=F.getOwn(totalP[turn]);
        for(int i=1;i<=n.length;i++){
            O=(Ownable)FieldHandler.Field[n[i-1]-1];
            p+=O.getPrice()/2;
        }
        
        if(totalP[turn].getMoney()+p<0){
            for(int i=1;i<=n.length;i++){
                O=(Ownable)FieldHandler.Field[n[i-1]-1];
                O.setOwner(null);
                GUI.removeOwner(n[i-1]);
            }
            GUI.removeAllCars(totalP[turn].name());
            this.DeadPlayers++;
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
                    O=(Ownable)FieldHandler.Field[n[i-1]-1];
                    ar[i-1]=O.getName()+" ("+O.getPrice()/2+")";
                }
                sell=GUI.getUserSelection(Lang.get("SAELGEHVAD"),ar);
                if(sell.substring(sell.length()-7,sell.length()-6).equals(" "))
                    name=sell.substring(0,sell.length()-7);
                else name=sell.substring(0,sell.length()-6);
                id=F.nameToNum(name);
                O=(Ownable)FieldHandler.Field[id-1];
                O.setOwner(null);
                GUI.removeOwner(id);
                totalP[turn].add(O.getPrice()/2);
                if(totalP[turn].getMoney()>=0 && n.length>1)
                    check=GUI.getUserButtonPressed(Lang.get("FLERE"),Lang.get("Y"),Lang.get("N"));
                if(check.equals(Lang.get("N")) || n.length==1) break;
            }
        }
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
        String name,col,tyype;
        
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
            tyype=GUI.getUserSelection(this.Lang.get("Chose_Type"),this.type);
            this.colors=removeElement(this.colors,Arrays.asList(this.colors).indexOf(col));
            totalP[i-1]=new Players(name,col,tyype,Lang,i-1);
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
     * Sætter sproget for boardet og antal spillere
     */
    private void PreGame(){
        this.Board.createBoard(this.Lang);
        if(this.TEST==0)
        {
            this.players=Integer.parseInt(GUI.getUserSelection(this.Lang.get("AS2"),"2","3","4","5","6"));
            this.totalP=new Players[this.players];
            this.AddPlayers();
        }
        else
        {
            String[][] str={
                {"Test1",colors[0],type[0]},
                {"Test2",colors[1],type[0]},
                {"Test3",colors[2],type[0]},
                {"Test4",colors[3],type[0]},
                {"Test5",colors[4],type[0]},
                {"Test6",colors[5],type[0]}
            };
            this.players=this.TEST_PLAYERS;
            this.totalP=new Players[this.players];
            
            for(int i=0;i<=this.players-1;i++) totalP[i]=new Players(str[i][0],str[i][1],str[i][2],Lang,i);
        }
    }
    
}
