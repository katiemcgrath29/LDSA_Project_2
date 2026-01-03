package assignment2;

import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {


        LinkedList<Activity> selectedActivities = new LinkedList<Activity>();


        if (activities.isEmpty()){
            return selectedActivities;
        }

        selectedActivities.add(activities.get(0));
        Activity lastSelected = activities.get(0);

        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);

            if (!currentActivity.overlap(lastSelected)){
                selectedActivities.add(currentActivity);
                lastSelected = currentActivity;
            }

        }

        return selectedActivities;
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {

        LinkedList<Integer> change = new LinkedList<Integer>();

        for (int i = 0; i < denominations.length; i++){
            int currentDenomination = denominations[i];


            while (amount >= currentDenomination){

                change.add(currentDenomination);

                amount = amount - currentDenomination;

            }


        }

        return change;
    }

    public static void main(String[] args) {

        LinkedList<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(1,1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 8));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 13));
        activities.add(new Activity(11, 12, 14));
        activitySelection(activities).forEach(a -> a.print());

        System.out.println();
        makeChange(1234, new int[] { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }).forEach(i -> System.out.println(i));
    }
}
