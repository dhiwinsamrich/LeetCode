

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sum(0, candidates, target, ans, temp);
        return ans;
    }

    private void sum(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        temp.add(arr[index]);
        sum(index, arr, target - arr[index], ans, temp);
        temp.remove(temp.size() - 1);

        sum(index + 1, arr, target, ans,temp);
    }
}