package app.aspectJ.annotations;

public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("Award taken!");
    }
}
