package KODER;

import FieldTypes.Fleet;
import FieldTypes.Jail;
import FieldTypes.Labor_camp;
import FieldTypes.Luck;
import FieldTypes.Parkering;
import FieldTypes.Starter;
import FieldTypes.Tax;
import FieldTypes.Territory;

public class FieldHandler{
    public static final Fields[] Field={
        new Starter("Start"),//1
        new Territory(2,"Rødovrevej","Blue",1200,50),
        new Luck("Prøv lykken"),
        new Territory(4,"Hvidovrevej","Blue",1200,50),
        new Tax("Betal indkomstskat 10% eller 4000kr.",4000),
  /*5*/ new Fleet("Scandlines-HH",4000,500),
        new Territory(7,"Roskildevej","Orange",2000,100),
        new Luck("Prøv lykken"),
        new Territory(9,"Valby Langgade","Orange",2000,100),
        new Territory(10,"Allégade","Orange",2400,150),
        new Jail("På besøg"),
        new Territory(12,"Frederiksberg Allé","Green",2800,200),
        new Labor_camp("Squash",3000,100),
        new Territory(14,"Bülowsvej","Green",2800,200),
        new Territory(15,"Gl. Kongevej","Green",3200,250),
 /*15*/ new Fleet("Mols-Linjen",4000,500),
        new Territory(17,"Bernstorffsvej","Gray",3600,300),
        new Luck("Prøv lykken"),
        new Territory(19,"Hellerupvej","Gray",3600,300),
        new Territory(20,"Strandvejen","Gray",4000,350),
        new Parkering("Parkering"),
        new Territory(22,"Trianglen","Red",4400,350),
        new Luck("Prøv lykken"),
        new Territory(24,"Østerbrogade","Red",4400,350),
        new Territory(25,"Grønningen","Red",4800,400),
        new Fleet("Scandlines-GR",4000,500),
        new Territory(27,"Bredgade","White",5200,450),
        new Territory(28,"Kgs. Nytorv","White",5200,450),
        new Labor_camp("Coca Cola",3000,100),
        new Territory(30,"Østergade","White",5600,500),
 /*30*/ new Jail("Fængsel"),
        new Territory(32,"Amagertorv","Yellow",6000,550),
        new Territory(33,"Vimmelskaftet","Yellow",6000,550),
        new Luck("Prøv lykken"),
        new Territory(35,"Nygade","Yellow",6400,600),
        new Fleet("Scandlines-RP",4000,500),
        new Luck("Prøv lykken"),
        new Territory(38,"Frederiksberggade","Magenta",7000,700),
        new Tax("Ekstraordinær statsskat: Betal 2000kr",2000),
        new Territory(40,"Rådhuspladsen","Magenta",8000,1000)
    };
    /**
     * Metode for at returnere array med numrene på felter som spiller ejer
     * @param Players p
     * @return int[] ar
     */
    public int[] getOwn(Players p){
        Ownable O;
        int t=0;
        for(int i=1;i<=40;i++){
            if(Field[i-1] instanceof Ownable){
                O=(Ownable)Field[i-1];
                // hvis feltet ejes af p�g�ldende spiller, inkrementeres t.
                if(O.getOwner()!=null && O.getOwner().getPlayer()==p.getPlayer()) t++;
            }
        }
        // opretter et array med l�ngden t af felter p�g�ldende spiller ejer.
        int[] ar=new int[t];
        t=-1;
        for(int i=1;i<=40;i++){
            if(Field[i-1] instanceof Ownable){
                O=(Ownable)Field[i-1];
                if(O.getOwner()!=null && O.getOwner().getPlayer()==p.getPlayer()){
                    t++;
                    // ar[t] retunerer array med numrene på felt numre der ejes.
                    ar[t]=i;
                }
            }
        }
        return ar;
    }
    // retunere feltnr
    public int nameToNum(String n){
        for(int i=1;i<=40;i++) if(Field[i-1].getName().equals(n)) return i;
        return 0;
    }
    
}
