class Solution {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, h = nums.length - 1;
        while (h >= l) {
            int mid = (l + h) / 2;
            if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == (n - 1) || nums[mid] > nums[mid + 1])) return mid;
            if (mid > 0 && nums[mid] >= nums[mid + 1]) h = mid - 1; else l = mid + 1;
        }
        return -1;
    }
}
