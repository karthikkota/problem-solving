
class ArrayProblem {

    // LC 75, T-O(n), S-O(1)
    public void sortColors(int[] nums) {
        int curPtr = 0;
        int color0Ptr = 0;
        int color2Ptr = nums.length - 1;

        while (curPtr <= color2Ptr) {
            if (nums[curPtr] == 0) {
                swap(nums, curPtr, color0Ptr);
                curPtr++;
                color0Ptr++;
            } else if (nums[curPtr] == 2) {
                swap(nums, curPtr, color2Ptr);
                color2Ptr--;
            } else {
                curPtr++;
            }
        }
    }

    private void swap(int[] nums, int first, int sec) {
        int temp = nums[first];
        nums[first] = nums[sec];
        nums[sec] = temp;
    }
}