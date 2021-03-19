package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {
    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHapiness(4);
    }

    @Override
    public void play(int hours) {
        increaseHapiness(hours * 3);
    }
}
