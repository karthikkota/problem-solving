
class ArrayProblem {

    // LC 75, T-O(N), S-O(1)
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

    // LC 54, T-O(N), S-O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStr = 0;
        int colStr = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        List<Integer> res = new ArrayList();

        while (rowStr < rowEnd && colStr < colEnd) {
            // L -> R
            for (int c = colStr; c < colEnd; c++) {
                res.add(matrix[rowStr][c]);
            }

            // T -> B
            rowStr++;
            for (int r = rowStr; r < rowEnd; r++) {
                res.add(matrix[r][colEnd - 1]);
            }

            // R -> L
            colEnd--;
            if (rowStr < rowEnd) {
                for (int c = colEnd - 1; c >= colStr; c--) {
                    res.add(matrix[rowEnd - 1][c]);
                }
                rowEnd--;
            }

            // B -> T
            if (colStr < colEnd) {
                for (int r = rowEnd - 1; r >= rowStr; r--) {
                    res.add(matrix[r][colStr]);
                }
                colStr++;
            }
        }

        return res;
    }

    // LC 442, T-O(nlogn), S-O(1)
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList();
        int strIdx = 1;

        while (strIdx < nums.length) {
            if (nums[strIdx - 1] == nums[strIdx]) {
                res.add(nums[strIdx]);
                strIdx += 2;
            } else {
                strIdx++;
            }
        }

        return res;
    }
}