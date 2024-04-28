class Solution {
    // static List<List<Integer>> matrix = new ArrayList<>();
    static void permutation(int[] ar,int fi,Set<List<Integer>> matrix){
    if(fi==ar.length-1){
    //   System.out.println(ar);
        List<Integer> temp = new ArrayList<>();
    for(int i=0;i<ar.length;i++){
        temp.add(ar[i]);
    }
    matrix.add(temp);
    // System.out.println(matrix);
    // System.out.println("--"+temp);
      return;
    }
    for(int i=fi;i<ar.length;i++){
      swap(ar,i,fi);
      permutation(ar,fi+1,matrix);
      swap(ar,i,fi);
    }
  }
    static void swap(int[] ar,int i,int fi){
      int temp=ar[i];
      ar[i]=ar[fi];
      ar[fi]=temp;
  }
        public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> matrix = new HashSet<>();
        permutation(nums,0,matrix);
        // System.out.print("+"+matrix);
      //  HashSet<List<Integer>> set = new HashSet<>(matrix);
      //   System.out.print("="+set+"=");
        for (List<Integer> element : matrix) {
           ans.add(element);
        }
        // System.out.print(ans+"=");

        return ans;
    }
}