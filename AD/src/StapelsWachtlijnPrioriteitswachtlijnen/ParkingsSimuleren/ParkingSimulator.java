package StapelsWachtlijnPrioriteitswachtlijnen.ParkingsSimuleren;

import java.util.Collection;

public interface ParkingSimulator {

    int simulate(int capacity, int returnTime, Collection<Event> arrivalEvents);

}
