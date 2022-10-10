class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] result = new boolean[n+1];
        result[0] = true;
        for(int i=0;i<n;i++){
            for(String word: wordDict){
                int start = i;
                int end = i + word.length();
                if(end<=s.length() && s.substring(i,end).equals(word)){
                    result[end] = (true & result[i]) | result[end];
                }
            }
        }
        return result[n];
    }
}
