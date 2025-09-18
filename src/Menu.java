import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ActivityManager manager = new ActivityManager();
        DisplayMenu menu = new DisplayMenu();
        //ClearScreen clear = new ClearScreen();
        int op, num;

        menu.displayMenu();
        op = scan.nextInt();

        do {
            switch (op) {
                case 1:
                    manager.createNewActivity(op);
                    System.out.println("────・୨ ✦ ୧・────");
                    System.out.println("✦ New option:");
                    System.out.print(">>");
                    op = scan.nextInt();
                    scan.nextLine();
                    break;
                case 2:
                    manager.createNewActivity(op);
                    System.out.println("────・୨ ✦ ୧・────");
                    System.out.println("✦ New option:");
                    System.out.print(">>");
                    op = scan.nextInt();
                    scan.nextLine();
                    break ;
                case 3:
                    manager.displayActivities(op);
                    System.out.print(">>");
                    num = scan.nextInt();
                    manager.selectActivity(num, op);

                    menu.displayMenu();
                    op = scan.nextInt();
                    scan.nextLine();
                    break;
                case 4:
                    manager.displayActivities(op);
                    System.out.print(">>");
                    num = scan.nextInt();
                    manager.selectActivity(num, op);

                    menu.displayMenu();
                    op = scan.nextInt();
                    scan.nextLine();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option. Select a new one.");
                    System.out.print(">>");
                    op = scan.nextInt();
                    scan.nextLine();
                    //start over
            }
        }while(op != 5);
        System.out.println("Closing...");
    }
}
