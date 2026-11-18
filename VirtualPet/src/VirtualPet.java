// Part A

public class VirtualPet {
    private String name;
    private int weight;
    private int energyLevel;
    private int happynessLevel;
    private int months;
    private int years;

    public VirtualPet(name){
        this.name = name;
        weight = 5;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name+"'s Information:\n Energy:" + energyLevel +"\n Happiness: " + happynessLevel +
                "\n Weight: " + weight + "g\n Age: " + months + " months and " + years +" years";
    }
    public void feed(){
        energyLevel++;
        weight ++;
    }
    public int getEnergyLevel(){
        return energyLevel;
    }
    public int getHappinessLevel(){
        return happynessLevel;
    }
    public void play(){
        if(happynessLevel>=0 || happynessLevel <=10 && weight > 5){
            happynessLevel++;
            weight--;
        }
    }
    public void updateStatus(){
        if(happynessLevel>=0 || happynessLevel <=10 && energyLevel>=0 || energyLevel <=10){
            energyLevel--;
            happynessLevel--;
            months++;
            if(months>11){
                months = months-12;
                years++;
            }
        }
    }
}
