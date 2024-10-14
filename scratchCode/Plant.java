public class Plant{
    private String name;
    private Light light;

    public Plant(String name, Light light){
        this.name = name;
        this.light = light;
    }

    public String getName(){
        return name;            
    }

    public Light getLight(){
        return light;
    }

    @Override
    public String toString(){
        return name + "(" + light + ")";
    }
}