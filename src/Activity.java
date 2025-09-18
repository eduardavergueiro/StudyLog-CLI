public class Activity {
    String name;
    private long start;
    private long finish;
    private double timeInMinutes;
    private long timeInNano;

    public Activity(String name){
        this.name = name;
    }

    void startTimer(){
        start = System.nanoTime();
    }

    void stopTimer(){
        finish = System.nanoTime();
    }

    double getTimeInMinutes(){
        timeInNano = finish - start;
        timeInMinutes = (double) timeInNano / 1_000_000_000.0;
        return timeInMinutes;
    }

    String getName(){
        return name;
    }
}
