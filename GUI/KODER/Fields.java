package KODER;

public abstract class Fields {
    private String name;

    public Fields(String name){
        setName(name);
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    
    public abstract void landOnField(Players p);
}
