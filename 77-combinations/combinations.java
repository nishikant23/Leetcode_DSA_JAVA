class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        f(n, k, 1, ls, ans);
        for(List<Integer> lst : ans){
            System.out.println("List of Size "+k+" is "+lst);
        }
        return ans;
    }
    public void f(int n, int k, int i, List<Integer> ls, List<List<Integer>> ans) {

        if(i==n+1) {
            if(ls.size()==k) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        ls.add(i);
        f(n, k, i+1, ls, ans);
        ls.remove(ls.size()-1);
        f(n, k, i+1, ls, ans);
    }
}