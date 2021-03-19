package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private String name;

    private int happiness;

    public Dog(String name) {
        happiness = 0;
        this.name = name;
    }

    protected void increaseHapiness(int amount) {
        happiness += amount;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void feed();

    public abstract void play(int hours);
}
