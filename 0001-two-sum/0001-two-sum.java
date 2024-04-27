class Solution {
    public int[] twoSum(int[] nums, int target) {
        int last = nums.length-1;
        for (int i=0;i<=last;i++){
            for (int j=i+1;j<=last;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
                if(nums[last-i]+nums[j]==target){
                    return new int[] {last-i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
}