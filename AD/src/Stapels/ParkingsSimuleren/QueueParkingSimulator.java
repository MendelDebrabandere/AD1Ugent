package Stapels.ParkingsSimuleren;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class QueueParkingSimulator implements ParkingSimulator {
    @Override
    public int simulate(int capacity, int returnTime, Collection<Event> arrivalEvents) {

        PriorityQueue<Event> prioq = new PriorityQueue<>((a, b) -> {
            if (a.timestamp() != b.timestamp()) return a.timestamp() - b.timestamp();
            return a.duration() - b.duration();
        });
        prioq.addAll(arrivalEvents);

        Event[] parking = new Event[capacity];
        Arrays.fill(parking, new Event(0, false, 0));

        while (prioq.peek() != null) {
            Event nextEvent = prioq.poll();
            int currTime = nextEvent.timestamp();

            boolean parked = false;

            for (int i = 0; i < capacity && !parked; ++i) {
                if (parking[i].timestamp() + parking[i].duration() <= currTime) {
                    parking[i] = nextEvent;
                    parked = true;
                }
            }

            if (!parked) {
                prioq.add(new Event(nextEvent.timestamp() + returnTime, nextEvent.isArrival(), nextEvent.duration()));
            }

        }

        int endTime = Integer.MIN_VALUE;
        for (Event e : parking) {
            endTime = Math.max(endTime, e.timestamp() + e.duration());
        }

        return endTime;

    }
}
