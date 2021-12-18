package interviewing.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxConcurrentEvents {

    public static int getMaxConcurrentEvents(List<Event> events) {
        List<Endpoint> endpoints = new ArrayList<>();
        for (Event event : events) {
            endpoints.add(new Endpoint(event.startTime, true));
            endpoints.add(new Endpoint(event.endTime, false));
        }
        Collections.sort(endpoints);
        int maxConcurrentEvents = 0;
        int numConcurrentEvents = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.startPoint) {
                numConcurrentEvents++;
            } else {
                numConcurrentEvents--;
            };
            maxConcurrentEvents = Math.max(maxConcurrentEvents, numConcurrentEvents);
        }

        return maxConcurrentEvents;
    }

    static class Event {
        int startTime;
        int endTime;

        public Event(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private static class Endpoint implements Comparable<Endpoint> {
        int time;
        boolean startPoint;

        Endpoint(int time, boolean startPoint) {
            this.time = time;
            this.startPoint = startPoint;
        }

        @Override
        public int compareTo(Endpoint endpoint) {
            if (this.time != endpoint.time) {
                return Integer.compare(this.time, endpoint.time);
            }

            return this.startPoint && !endpoint.startPoint ? -1 :
                    !this.startPoint && endpoint.startPoint ? 1 : 0;
        }
    }
}
