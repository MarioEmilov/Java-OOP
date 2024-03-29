package Pizza_Calories_04;

import Pizza_Calories_04.utils.TypeUtils;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!TypeUtils.FLOUR_TYPES.containsKey(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }
    private void setBakingTechnique(String bakingTechnique) {
        if (!TypeUtils.BAKING_TECHNIQUES.containsKey(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight){
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return this.weight * 2
                * TypeUtils.FLOUR_TYPES.get(this.flourType)
                * TypeUtils.BAKING_TECHNIQUES.get(this.bakingTechnique);
    }
}
