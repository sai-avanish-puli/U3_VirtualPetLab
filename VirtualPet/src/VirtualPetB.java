public class VirtualPetB {

    private String name;
    private int energyLevel;
    private int happinessLevel;
    private int weight;
    private int ageYears;
    private int ageMonths;

    public VirtualPetB(String petName) {
        name = petName;
        energyLevel = 0;
        happinessLevel = 0;
        weight = 5;
        ageYears = 0;
        ageMonths = 0;
    }

    public String getName() {
        return name;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void feed(Food food) {
        energyLevel += food.getEnergyIncrease();
        happinessLevel += food.getHappinessIncrease();
        weight += food.getWeightGain();

        // Keep energy and happiness between 0 and 10
        if (energyLevel > 10) {
            energyLevel = 10;
        }
        if (energyLevel < 0) {
            energyLevel = 0;
        }

        if (happinessLevel > 10) {
            happinessLevel = 10;
        }
        if (happinessLevel < 0) {
            happinessLevel = 0;
        }
    }

    public boolean play(Game game) {
        boolean won = game.isWinner();

        weight -= game.getWeightDecr();

        // Weight cannot go below 5
        if (weight < 5) {
            weight = 5;
        }

        if (won) {
            happinessLevel += game.getHappinessIncr();
        } else {
            happinessLevel--;
        }

        // Keep happiness between 0 and 10
        if (happinessLevel > 10) {
            happinessLevel = 10;
        }
        if (happinessLevel < 0) {
            happinessLevel = 0;
        }

        return won;
    }

    public void updateStatus() {
        if (happinessLevel > 0) {
            happinessLevel--;
        }

        if (energyLevel > 0) {
            energyLevel--;
        }

        ageMonths++;

        if (ageMonths == 12) {
            ageYears++;
            ageMonths = 0;
        }
    }

    public String toString() {
        return name + "'s Information:\n"
                + "Energy: " + energyLevel + "\n"
                + "Happiness: " + happinessLevel + "\n"
                + "Weight: " + weight + "g\n"
                + "Age: " + ageMonths + " months and "
                + ageYears + " years";
    }
}
