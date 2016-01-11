package KODER;

public class FieldHandler{
    public static final Fields[] Field={
        new Starter("Start"),//1
        new Territory("Rødovrevej",1200,50,250,750,2250,4000,6000,1000),
        new Luck("Prøv lykken"),
        new Territory("Hvidovrevej",1200,50,250,750,2250,4000,6000,1000),
        new Tax("Betal indkomstskat 10% eller 4000kr.",4000),
        new Fleet("Scandlines-HH",4000,500),
        new Territory("Roskildevej",2000,100,600,1800,5400,8000,11000,1000),
        new Luck("Prøv lykken"),
        new Territory("Valby Langgade",2000,100,600,1800,5400,8000,11000,1000),
        new Territory("Allégade",2400,150,800,2000,6000,9000,12000,1000),
        new Jail("På besøg"),
        new Territory("Frederiksberg Allé",2800,200,1000,3000,9000,12500,15000,2000),
        new Labor_camp("Squash",3000,100),
        new Territory("Bülowsvej",2800,200,1000,3000,9000,12500,15000,2000),
        new Territory("Gl. Kongevej",3200,250,1250,3750,10000,14000,18000,2000),
        new Fleet("Mols-Linjen",4000,500),
        new Territory("Bernstorffsvej",3600,300,1400,4000,11000,15000,19000,2000),
        new Luck("Prøv lykken"),
        new Territory("Hellerupvej",3600,300,1400,4000,11000,15000,19000,2000),
        new Territory("Strandvejen",4000,350,1600,4400,12000,16000,20000,2000),
        new Parkering("Parkering"),
        new Territory("Trianglen",4400,350,1800,5000,14000,17500,21000,3000),
        new Luck("Prøv lykken"),
        new Territory("Østerbrogade",4400,350,1800,5000,14000,17500,21000,3000),
        new Territory("Grønningen",4800,400,2000,6000,15000,18500,22000,3000),
        new Fleet("Scandlines-GR",4000,500),
        new Territory("Bredgade",5200,450,2200,6600,16000,19500,23000,3000),
        new Territory("Kgs. Nytorv",5200,450,2200,6600,16000,19500,23000,3000),
        new Labor_camp("Coca Cola",3000,100),
        new Territory("Østergade",5600,500,2400,7200,17000,20500,24000,3000),
        new Jail("Fængsel"),
        new Territory("Amagertorv",6000,550,2600,7800,18000,22000,25000,4000),
        new Territory("Vimmelskaftet",6000,550,2600,7800,18000,22000,25000,4000),
        new Luck("Prøv lykken"),
        new Territory("Nygade",6400,600,3000,9000,20000,24000,28000,4000),
        new Fleet("Scandlines-RP",4000,500),
        new Luck("Prøv lykken"),
        new Territory("Frederiksberggade",7000,700,3500,10000,22000,26000,30000,4000),
        new Tax("Ekstraordinær statsskat: Betal 2000kr",2000),
        new Territory("Rådhuspladsen",8000,1000,4000,12000,28000,34000,40000,4000)
    };



    public int getNumOwn(Players player){
        int num=0;
        Ownable O;
        for(int i=1;i<=40;i++){
            if(!(Field[i-1] instanceof Ownable)) continue;
            O=(Ownable)Field[i-1];
            if(O.getOwner().name().equals(player.name())) num++;
        }
        return num;
    }

    public String[] getOwn(Players player){
        
        return null;
    }
}
