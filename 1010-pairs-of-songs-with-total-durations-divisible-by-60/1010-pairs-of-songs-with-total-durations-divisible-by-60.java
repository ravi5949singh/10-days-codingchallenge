class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        int[] freq = new int[60];

        for (int i = 0; i < time.length; i++) {

            int rem = time[i] % 60;
            int need = (60 - rem) % 60;

            count += freq[need];

            freq[rem]++;
        }

        return count;
    }
}