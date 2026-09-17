class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];
        int INF = 1000000;

        // Initially no valid subarray
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Remove elements until sum <= target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // If we found a subarray with sum = target
            if (sum == target) {

                int currentLength = right - left + 1;

                // Previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(
                        ans,
                        currentLength + best[left - 1]
                    );
                }

                // Store minimum subarray length till right
                if (right == 0) {
                    best[right] = currentLength;
                } else {
                    best[right] = Math.min(
                        best[right - 1],
                        currentLength
                    );
                }

            } else {

                // No new subarray ending at right
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}