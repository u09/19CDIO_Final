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
    private int DELAY=600;
    private String[] colors={Lang.get("F1"),Lang.get("F2"),Lang.get("F3"),Lang.get("F4"),Lang.get("F5"),Lang.get("F6")};
    private String[] type={Lang.get("T1"),Lang.get("T2"),Lang.get("T3"),Lang.get("T4")};
    private final int TEST=0;
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
        else if(this.TEST==19) test.printOwn(totalP[0]);
    }
  
    /**
     * Starter spillet. (While-loopet)
     */
    private void StartGame(){
        boolean CheckJail=false;//Tjekker om spiller er jail
        int[] D;//Dice
        int TI=-1;//Hvor mange gange while-loopet kører
        int ens=0;//Hvor mange gange man har slået 2 ens i træk
        Jail J=(Jail) FieldHandler.Field[10];//Objekt af Jail
        while(true){
            TI++;
            GUI.getUserButtonPressed(this.Lang.get("KT")+totalP[turn].name(),"OK");
            
            //Hvis han er i fængsel, kører vi landOnField før han slår
            if(J.isJailed(turn)) FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            if(this.TEST!=0 && new Test().TestDice(TI,TEST)[0]!=0 && new Test().TestDice(TI,TEST)[1]!=0) D=new Test().TestDice(TI,TEST);
            else if(this.TEST!=0 && (new Test().TestDice(TI,TEST)[0]==0 && new Test().TestDice(TI,TEST)[1]==0)) break;
            else D=Dice.Throw();
            
            GUI.setDice(D[0],D[1]);
            System.out.print("Spiller"+(turn+1)+" slog {"+D[0]+";"+D[1]+"}"+" ("+totalP[turn].getPosition()+"->"+((D[0]+D[1]+totalP[turn].getPosition())%40)+")\t\t");
            
            //Hvis han slår 2 ens, 3 gange i træk
            if(D[0]==D[1] && ens==2){
                ens=0;
                MoveToJail(totalP[turn]);
                CT();
                continue;
            }
            
            if(J.isJailed(turn)){
                //Hvis terningerne ikke er ens
                if(D[0]!=D[1]){
                    //Hvis han har prøvet at slå sig ud af jail, 3 gange i træk
                    if(J.Nthrows(turn)==3) J.payJail(totalP[turn]);//Tvunget betaling
                    else{
                        GUI.showMessage(Lang.get("Ikke2ens"));
                        this.CT();
                        continue;
                    }
                }
                else{
                    //Slår sig ud af jail, betaler 1000 og får 1000: 1000-1000=0
                    J.payJail(totalP[turn]);
                    totalP[turn].add(1000);
                    //Sætter vi til true for at han ikke skal slå igen fordi han
                    //Er kommet ud af jail.
                    CheckJail=true;
                }
            }
            
            //Bevæger spilleren
            totalP[this.turn].move(D[0]+D[1],this.DELAY);
            
            //Tjekker om spiller har passeret start
            CheckMoneyStart(totalP[turn],D);
            
            //Kører landOnField
            FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            
            //Tjekker om man har trukket et move-kort
            if(LuckController.LOF){
                LuckController.LOF=false;
                FieldHandler.Field[totalP[turn].getPosition()-1].landOnField(totalP[turn]);
            }
            
            /* Første betingelse er hvis han ikke slår to ens og ikke er død. 
             * Anden mulig betingelse er hvis han er i fængsel og har ikke slået med terningerne mens han har været i fængsel dvs. han er lige kommet ind i jail.
             * Trejde mulig betingelse er CheckJail som er true når han lige har slået sig ud af fængsel dvs. han skal ikke slå igen.
             */
            if((D[0]!=D[1] && !totalP[turn].dead()) || (J.Nthrows(turn)==0 && J.isJailed(turn)) || CheckJail){
                this.CT();
                ens=0;
                CheckJail=false;
            }
            //Hvis spiller er død
            else if(totalP[turn].dead()){
                this.DEAD();
                if(totalP[turn].dead()){
                    ens=0;
                    this.CT();
                    //Tjekker om en spiller har vundet
                    if(CheckWin()) break;
                }
            }
            //Hvis spilleren har slået 2 ens
            else ens++;
            if(TI==this.players-1) firstR=false;
            System.out.println();
        }
        if(this.TEST!=0) GUI.showMessage(Lang.get("TEST_FAEDIG"));//Hvis testen er færdig
        else GUI.showMessage(Lang.get("VUNDET")+totalP[turn-1].name()+"!!!!");//Hvis en spiller har vundet
        GUI.close();
    }
    
    private boolean CheckWin(){
        if(this.players-this.DeadPlayers==1) return true;//Tjekker om der er 1 levende spiller tilbage
        return false;
    }
    
    private void CheckMoneyStart(Players p,int[] D){
        //Sætter f til at være spillerens position, minus de to terninger lagt sammen
        int f=p.getPosition()-(D[0]+D[1]);
        //Hvis f er mindre eller det samme som 1, og spillerens position ikke er det
        //samme som 1, og variablen firstR er false, skal spilleren have 4000.
        //firstR bliver false når alle spillere har slået med terningen 1 gang
        if(f<=1 && p.getPosition()!=1 && firstR==false) p.add(4000);
    }
    
    /**
     * Flytter spiller til Jail
     * @param p - Players object af aktuelle spiller
     */
    private void MoveToJail(Players p){
        //Fjerner spilleren fra nuværende position
        GUI.removeCar(p.getPosition(),p.name());
        //Sætter spillerens position til at besøge fængslet i GUI'en
        GUI.setCar(11,p.name());
        //Sætter spillerens position til at være 31 i systemet
        p.setPosition(31);
        //Kører landOnField på spilleren
        FieldHandler.Field[p.getPosition()-1].landOnField(p);
    }
    
    private void DEAD(){
        Ownable O;
        String sell;
        int p=0;
        //Sætter n til at indeholde alle spillerens grunde
        int[] n=F.getOwn(totalP[turn]);
        for(int i=1;i<=n.length;i++){//Looper gennem grundene
            O=(Ownable)FieldHandler.Field[n[i-1]-1];//Kaster til Ownable
            p+=O.getPrice()/2;//Tilføjer halvdelen af grundens pris ind i p
        }
        
        //Hvis spillerens pengebeholdning plus p er mindre end 0
        if(totalP[turn].getMoney()+p<0){
            //Looper igennem alle spillerens grunde
            for(int i=1;i<=n.length;i++){
                //Kaster field til ownable
                O=(Ownable)FieldHandler.Field[n[i-1]-1];
                //Sætter ejeren af feltet til at være null
                O.setOwner(null);
                //Fjerner feltets ejer fra GUI'en
                GUI.removeOwner(n[i-1]);
            }
            //Fjerner spilleren fra brættet
            GUI.removeAllCars(totalP[turn].name());
            //Inkrementerer DeadPlayers
            this.DeadPlayers++;
        }
        else{
            String[] ar;
            String name;
            int id;
            String check="";
            while(true){
                n=F.getOwn(totalP[turn]);//Sætter n til at være spillerens grunde
                ar=new String[n.length];//Initialiserer et array med længden af n
                for(int i=1;i<=n.length;i++){//Looper gennem spillerens grunde
                    O=(Ownable)FieldHandler.Field[n[i-1]-1];//Kaster til ownable
                    //Sætter det [i-1]'ende index til at være: Navn (Pris)
                    ar[i-1]=O.getName()+" ("+O.getPrice()/2+")";
                }
                //Vælger en grund fra listen i arrayet ar
                sell=GUI.getUserSelection(Lang.get("SAELGEHVAD"),ar);
                //Tjekker om det 7'ende-sidste tegn er et mellemrum
                if(sell.substring(sell.length()-7,sell.length()-6).equals(" "))
                    //Hvis det er, splitter vi strengen fra det 7'ende-sidste tegn
                    //og beholder den første del af strengen
                    name=sell.substring(0,sell.length()-7);
                //Ellers splitter vi ved det sjette-sidste tegn
                else name=sell.substring(0,sell.length()-6);
                //Kører en metode der konvereterer et navn til et id (feltnummer)
                id=F.nameToNum(name);
                O=(Ownable)FieldHandler.Field[id-1];//Kaster feltet til et ownable
                O.setOwner(null);//Sætter ejeren til at være null
                GUI.removeOwner(id);//Fjerner ejeren af grunden fra GUI'en
                //Tilføjer halvdelen af prisens grund, til ejeren
                totalP[turn].add(O.getPrice()/2);
                //Tjekker om spillerens pengebeholdning er større eller det samme
                //som 0, og om spilleren har flere grunde til rådighed
                if(totalP[turn].getMoney()>=0 && n.length>1)
                    //Hvis det er sandt, spørger den om han vil sælge flere grunde
                    check=GUI.getUserButtonPressed(Lang.get("FLERE"),Lang.get("Y"),Lang.get("N"));
                //Hvis han ikke har flere grunde til rådighed, eller han ikke gider
                //at sælge flere grunde, breaker den ud af loopet
                if(check.equals(Lang.get("N")) || n.length==1) break;
            }
        }
    }
    
    /**
     * Skifter spillerens tur. Spinger dead spillere over
     */
    private void CT(){
        //Tjekker om det er den sidste spillers tur, og sætter turen til at være den
        //første spillers tur hvis det er true
        if(this.turn==this.players-1) this.turn=0;
        //Ellers inkrementerer den turen med 1
        else this.turn++;
        //Tjekker om den nye tur er en død spiller, og kører sigselv hvis den er true
        if(this.totalP[turn].dead()) CT();
    }
    
    /**
     * Tilfoejer spillere til boardet (navn,penge,farve,type)
     */
    private void AddPlayers(){
        boolean check=true;
        String name,col,tyype;
        
        //Looper antallet af spillere
        for(int i=1;i<=this.players;i++){
            //Check er true hvis det sidst indtastede navn er gyldigt, og ellers er
            //den false
            if(check) name=GUI.getUserString(Lang.get("NAME")+i);
            else name=GUI.getUserString(Lang.get("NAME2")+i);
            check=true;
            //Hvis vi allerede har tilføjet 1 spiller
            if(i>1){
                first:
                //Looper igennem de navne der allerede er blevet tilføjet
                for(int t=1;t<=i-1;t++){
                    //Hvis det indtastede navn er det samme som et andet navn der
                    //allerede er indtastet
                    if(totalP[t-1].name().equals(name)){
                        //Dekrementer i, sæt check til false og break det inderste
                        //for-loop
                        i--;
                        check=false;
                        break first;
                    }
                }
            }
            
            //Hvis check er false, skal loopet ignorere resten af loopet
            if(!check) continue;
            
            //Spørger hvilken farve bil spilleren skal have
            col=GUI.getUserSelection(this.Lang.get("Chose_Color"),this.colors);
            //Spørger hvilken type bil spilleren skal have
            tyype=GUI.getUserSelection(this.Lang.get("Chose_Type"),this.type);

            //Fjerner den valgte farve fra listen af gyldige this.colors=removeElement(this.colors,Arrays.asList(this.colors).indexOf(col));
            //Tilføjer spilleren i totalP-arrayet
            totalP[i-1]=new Players(name,col,tyype,Lang,i-1);
        }
    }
    
    /**
     * Generel metode for at fjerne element fra array
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
        this.Board.createBoard(this.Lang);//Laver boardet med det valgte sprog
        if(this.TEST==0)//Hvis vi ikke kører en test
        {
            //Spørger hvor mange spillere der skal være
            this.players=Integer.parseInt(GUI.getUserSelection(this.Lang.get("AS2"),"2","3","4","5","6"));
            this.totalP=new Players[this.players];
            //Kører AddPlayers
            this.AddPlayers();
        }
        //Hvis vi kører en test
        else
        {
            //Initialiserer et array med navn, farve og type bil
            String[][] str={
                {"Test1",colors[0],type[0]},
                {"Test2",colors[1],type[0]},
                {"Test3",colors[2],type[0]},
                {"Test4",colors[3],type[0]},
                {"Test5",colors[4],type[0]},
                {"Test6",colors[5],type[0]}
            };
            //Sætter players til at være TEST_PLAYERS
            this.players=this.TEST_PLAYERS;
            //Sætter længden af totalP til at være det players
            this.totalP=new Players[this.players];
            //Looper antallet af players hvor der bliver sat et objekt af Players()
            //ind i array-indexene i totalP med navn, farve og type fra str[][]
            for(int i=0;i<=this.players-1;i++) totalP[i]=new Players(str[i][0],str[i][1],str[i][2],Lang,i);
        }
    }
}
