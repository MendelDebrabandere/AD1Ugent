package StapelsWachtlijnPrioriteitswachtlijnen.ParkingsSimuleren;

public class Event {

    private final int timestamp;
    private final boolean isArrival;
    private final int duration;

    public Event(int timestamp, boolean isArrival, int duration) {
        this.timestamp = timestamp;
        this.isArrival = isArrival;
        this.duration = duration;
    }

    public int timestamp() {
        return timestamp;
    }

    public boolean isArrival() {
        return isArrival;
    }

    public int duration() {
        return duration;
    }

    public String toString() {
        return String.format("new Event(%d, %b, %d)", timestamp, isArrival, duration);
    }

//    public String toRepr() {
//        return isArrival ? String.format("+(at %d for %d)", timestamp, duration)
//                         : String.format("-(at %d)", timestamp)
//                         ;
//    }

}

