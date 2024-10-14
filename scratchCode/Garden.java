import java.util.ArrayList;

public class Garden{
    private Light light;
    private ArrayList<Plant> plants;

    public Garden(){
        this.light = light;
        this.plants = new ArrayList<Plant>();
    }

    public void newPlant(Plant plant){
        plants.add(plant);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for (Plant plant : plants){
            result.append(plant.toString()).append(", ");
        }

        if(result.length() > 0){
            result.setLength(result.length() - 2);
        }

        return result.toString();
    }
}