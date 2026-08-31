class Solution {

    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    public void mergeSort(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        // Left part
        mergeSort(nums, low, mid);

        // Right part
        mergeSort(nums, mid + 1, high);

        // Merge both parts
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;       // left array pointer
        int j = mid + 1;   // right array pointer
        int k = 0;         // temp pointer

        // Dono parts ko compare karo
        while (i <= mid && j <= high) {

            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        // Left mein elements bach gaye
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // Right mein elements bach gaye
        while (j <= high) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // temp ko original array mein copy karo
        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }
}