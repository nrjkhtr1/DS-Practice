class Solution {
    public String checkPalindrome(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
    
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        String result = "";
        for(int i=0;i<s.length()-1;i++){
            String checkPalindrome  = checkPalindrome(s, i,i);
            if(checkPalindrome.length() > result.length()){
                result = checkPalindrome;
            }

            checkPalindrome = checkPalindrome(s,i,i+1);
            if(checkPalindrome.length() > result.length()){
                result = checkPalindrome;
            }
        }
        return result;
    }
}