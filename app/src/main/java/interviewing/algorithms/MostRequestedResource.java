package interviewing.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MostRequestedResource {
    public static void main(String[] argv) {
        String[][] logs1 = new String[][] {
                { "53651", "user_5", "resource_3" },
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                {"54359", "user_1", "resource_3"},
                { "54001", "user_1", "resource_3" },
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };

        ResourceWithAccess logs1MostAccess = mostRequestedResource(logs1);
        ResourceWithAccess logs2MostAccess = mostRequestedResource(logs2);
        ResourceWithAccess logs3MostAccess = mostRequestedResource(logs3);

        System.out.println("logs1: " + logs1MostAccess.resourceName + ": " + logs1MostAccess.accessAmount);
        System.out.println("logs2: " + logs2MostAccess.resourceName + ": " + logs2MostAccess.accessAmount);
        System.out.println("logs3: " + logs3MostAccess.resourceName + ": " + logs3MostAccess.accessAmount);

    }

    public static ResourceWithAccess mostRequestedResource(String[][] logs) {
        Map<String, Integer> resourceToAccess = new HashMap<>();
        for (String[] logEntry : logs) {
            String resourceName = logEntry[2];
            resourceToAccess.put(resourceName, 0);
        }

        for (int i = 0; i < logs.length; i++) {
            String currResource = logs[i][2];
            int currWindow = Integer.parseInt(logs[i][0]);
            int currValidAccesses = 1;
            for (int j = 0; j < logs.length; j++) {
                if (j != i) {
                    int currTimestamp = Integer.parseInt(logs[j][0]);
                    int window = Math.abs(currTimestamp - currWindow);
                    if (logs[j][2].equals(currResource) && window <= 300) {
                        currValidAccesses++;
                    }
                }
            }
            if (currValidAccesses > resourceToAccess.get(currResource)) {
                resourceToAccess.put(currResource, currValidAccesses);
            }
        }

        int maxAccesses = Integer.MIN_VALUE;
        String maxResource = "";
        for (String resourceName : resourceToAccess.keySet()) {
            int maxAccessForResource = resourceToAccess.get(resourceName);
            if (maxAccessForResource > maxAccesses) {
                maxAccesses = maxAccessForResource;
                maxResource = resourceName;
            }
        }

        return new ResourceWithAccess(maxResource, maxAccesses);
    }

    public static class ResourceWithAccess {

        public String resourceName;
        public int accessAmount;

        public ResourceWithAccess(String resourceName, int accessAmount) {
            this.resourceName = resourceName;
            this.accessAmount = accessAmount;
        }
    }
}

