package app.aspectJ.annotations;

public class Performer implements IPerformer {

    public void perform() {
        System.out.println("JUGGLING 15 BEANBAGS");
//        int a = 1 / 0; // triggering an exception
    }

}
