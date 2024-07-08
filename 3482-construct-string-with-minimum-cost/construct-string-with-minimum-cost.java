class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isLast;
        int cost;
        
        TrieNode() {
            children = new TrieNode[26];
            isLast = false;
            cost = Integer.MAX_VALUE;
        }
    }
    
    TrieNode root;
    
    
    private void insert(String word, int cost) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if (node.children[c-'a']==null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLast = true;
        node.cost = Math.min(node.cost, cost);
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        root = new TrieNode();
        for(int i=0; i<words.length; i++) {
            insert(words[i], costs[i]);
        }
        long[] dp = new long[target.length()];
        Arrays.fill(dp, -1);
        long ans = solve(0, target, dp);
        if(ans>=Integer.MAX_VALUE) return -1;
        return (int)ans;
    }

    private long solve(int i, String target, long[] dp) {
        if(i>=target.length()) {
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        TrieNode node = root;
        long min = Integer.MAX_VALUE;
        for(int j=i; j<target.length(); j++) {
            if (node.children[target.charAt(j)-'a']!=null) {
                node = node.children[target.charAt(j)-'a'];
            } else {
                break;
            }
            if (node.isLast) {
                min = Math.min(min, node.cost+solve(j+1, target, dp));
            }
        }
        return dp[i]=min;
    }
}
