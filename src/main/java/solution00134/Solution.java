package solution00134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fullDistance = gas.length;
        int gasTotal = 0;
        int costTotal = 0;

        for (int i = 0; i < fullDistance; i++) {
            costTotal += cost[i];
            gasTotal += gas[i];
        }

        if (gasTotal < costTotal) {
            return -1;
        }

        int fuel = 0;
        int startingPos = 0;

        for (int i = 0; i < fullDistance; i++) {
            fuel += gas[i] - cost[i];
            if (fuel < 0) {
                fuel = 0;
                startingPos = i + 1;
            }
        }

        return startingPos;
    }
}
