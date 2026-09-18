class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int startSec = toSeconds(startTime);
        int endSec = toSeconds(endTime);

        int diff = endSec - startSec;
        if (diff < 0) {
            diff += 24 * 3600; // Passed midnight
        }

        return diff;
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}