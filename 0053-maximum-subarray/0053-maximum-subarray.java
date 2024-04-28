class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,result=nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            result = sum > result ? sum : result;
            sum = sum < 0 ? 0 : sum;
        }
        return result;
    }
}