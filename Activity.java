package assignment2;

public class Activity {
    private int id;
    private int start;
    private int finish;


    public Activity(int id, int start, int finish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
    }


    public Boolean overlap(Activity activity) {
        return !((start >= activity.finish) || (activity.start >= finish));
    }

    public void print() {
        System.out.printf("%3d", id);
        System.out.println(" ".repeat(start) + "#".repeat(finish-start));
    }
}
