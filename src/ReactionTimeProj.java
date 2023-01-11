import java.util.Scanner;

public class ReactionTimeProj {

    public static void main(String[] args) throws InterruptedException {

        Scanner reaction = new Scanner(System.in);
        String decorativeLine = "-----------------------";

        int iniTimer = 3;

        for (int i = iniTimer; i >= 0; i--) {

            if (i == 0) {
                System.out.println("Go!!");
                break;
            }

            System.out.println(i);
            Thread.sleep(1000);

        }

        // Storing start time of Scanner as the initial reaction time
        Long start = System.currentTimeMillis();
        // Gathering the next String but not storing it
        reaction.next();
        // Storing the end time of the Scanner as the last reaction time
        Long end = System.currentTimeMillis();

        // Reaction time would be calculated by subtracting the ending reaction time from the first.
        long reactionTime = end - start;

        // Print statement
        System.out.println("Your reaction time for typing is: " + reactionTime + " ms.");

        // Storage for time conversions
        double secondsTime = (double) reactionTime/ 1000;
        double hoursTime = secondsTime / 3600;
        double dayTime = hoursTime / 24;
        double weekTime = dayTime / 7;

        // Prompt the user to whether they'd like to convert their time or not (not a useful feature really, but fun)

        System.out.println("Would you like to convert your time into a different measurement? Y / N");

        // There is no .nextChar method, so we get the next String and take the first character.
        char ans1 = reaction.next().charAt(0);
        char yes = 'Y';
        char no = 'N';


        if (ans1 == yes) {

            System.out.println("What unit of time would you like to convert to?");
            System.out.println(decorativeLine);
            String [] list = {"(0) Seconds", "(1) Hours", "(2) Days", "(3) Weeks"};


            for (String s : list) {
                System.out.println(s);
                Thread.sleep(1000);
            }

            int ans2 = reaction.nextInt();

            if (ans2 < 0 || ans2 > 3) {
                System.out.println("Invalid selection! Try again.");
                ans2 = reaction.nextInt();
            }

            switch (ans2) {
                case 0 -> System.out.println("Your reaction time in seconds is: " + String.format("%.2f", secondsTime) + "s.");
                case 1 -> System.out.println("Your reaction time in hours is: " + hoursTime + " hours.");
                case 2 -> System.out.println("Your reaction time in days is: " + dayTime + " days.");
                case 3 -> System.out.println("Your reaction time in weeks is: " + weekTime + " weeks.");
            }

        }

        if (ans1 == no) {
            System.out.println("Thanks for using the program!");
        }



        // Converting to seconds while rounding to two decimal places
        // System.out.println("In other words, your reaction time is " + String.format("%.2f", roundedTime) + " in seconds.");



    }

}
