import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class ActivityManager {
    LinkedList <Activity> activities = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    void createNewActivity(int op){
        Activity newActivity = null; //para armazenas o novo objeto
        String activityName;

        System.out.println("Name the new activity: ");
        System.out.print(">>");
        activityName = scan.nextLine();

        if(op == 1){
            newActivity = new Subject(activityName);
        }
        else if(op == 2){
            newActivity = new Task(activityName);
        }else{
            System.out.println("Invalid option.");
            return;
        }

        activities.add(newActivity);
    }

    void displayActivities(int op){
        int i = 1;
        System.out.println("✦•────────────────────•꩜•────────────────────•✦");

        if(op == 3){
            System.out.println("Select a subject. (0) to exit.");
            for(Activity activity : activities){
                if(activity instanceof Subject){
                    System.out.print(i + ". ");
                    System.out.println(activity.getName());
                    i++;
                }
            }
        }
        else if(op == 4){
            System.out.println("Select a task. (0) to exit.");
            for(Activity activity : activities){
                if(activity instanceof Task){
                    System.out.print(i + ". ");
                    System.out.println(activity.getName());
                    i++;
                }
            }
        }

        return;
    }

    void selectActivity(int activityNumber, int op){
        LinkedList <Activity> filteredList = new LinkedList<>();
        int yn;

        if (activityNumber != 0) {

            //criando uma lista temporária filtrada
            for (Activity activity : activities) {
                if (op == 3) {
                    if (activity instanceof Subject) {
                        filteredList.add(activity);
                    }
                } else if (op == 4) {
                    if (activity instanceof Task) {
                        filteredList.add(activity);
                    }
                }
            }

            for (Activity activity : filteredList) {
                if (activity == filteredList.get(activityNumber - 1)) {
                    System.out.println(activity.getName());
                    System.out.println("1. Start Timer" + "\n" + "2. Stop Timer");
                    System.out.print(">>");
                    do {
                        op = scan.nextInt();
                        scan.nextLine();
                        if (op == 1) {
                            activity.startTimer();
                            System.out.print(">>");
                        } else if (op == 2) {
                            activity.stopTimer();
                            break;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    } while (true);

                    System.out.println("Time in seconds: " + activity.getTimeInMinutes());

                    if (activity instanceof Task) {
                        System.out.println("Did you complete this task?");
                        System.out.println("1. Yes -- delete task");
                        System.out.println("2. No");
                        yn = scan.nextInt();
                        scan.nextLine();

                        if (yn == 1) {
                            activities.remove(activity);
                        }
                    }

                    if (activity instanceof Subject) {
                        Subject subject = (Subject) activity;
                        subject.totalTimeSpent(activity.getTimeInMinutes());
                        System.out.println("Total time spent (sec): " + subject.totalTimeSpent);
                    }
                }
            }
        }
    }
}