public class Task extends Activity{

    void displayTimeSpent(){
        System.out.println(getTimeInMinutes());
    }

    public Task (String name){
        super(name);
    }

}
