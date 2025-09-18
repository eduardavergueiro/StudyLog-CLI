public class Subject extends Activity{
    double totalTimeSpent;
    double addTime;

    void totalTimeSpent(double addTime){
        totalTimeSpent += addTime;
    }

    public Subject(String name){
        super(name);
    }
}
