public class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    public Timer(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public void incrementHours(){
        hours++;
        if (hours>=24){
            hours -= 24;
        }
    }

    public void decrementHours(){
        hours--;
        if (hours<0){
            hours += 24;
        }
    }

    public int getHours(){
        return hours;
    }

    public void incrementMinutes(){
        minutes++;
        if (minutes>=60){
            minutes-=60;
            incrementHours();
        }
    }
    public void decrementMinutes(){
        minutes--;
        if (minutes<0){
            minutes+=60;
            decrementHours();
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void incrementSeconds(){
        seconds++;
        if (seconds>=60){
            seconds-=60;
            incrementMinutes();
        }
    }

    public void decrementSeconds(){
        seconds--;
        if (seconds<0){
            seconds+=60;
            decrementMinutes();
        }
    }

    public int getSeconds(){
        return seconds;
    }

    public String toString () {
        return "Timer "+hours+":"+minutes+":"+seconds;
    }
}