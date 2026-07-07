class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean f1 = true;
        boolean f2 = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                f2 = false;

            if (nums[i] < nums[i - 1])
                f1 = false;
        }
        return f1 || f2;
    }
}
