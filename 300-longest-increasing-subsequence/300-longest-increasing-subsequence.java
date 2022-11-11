class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n+1];
        lis[0] = 1;
        int longestSeq = 1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(1 + lis[j], lis[i]);
                }
                else{
                    lis[i] = Math.max(lis[i], 1);
                }
            }
        }
        for(int i: lis){
            longestSeq = Math.max(i, longestSeq);
        }
        return longestSeq;
    }
}