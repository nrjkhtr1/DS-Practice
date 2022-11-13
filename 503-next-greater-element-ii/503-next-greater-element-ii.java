class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<Integer>();
        int[] answer = new int[nums.length];
        int i=1;
        s.push(0);
        
        while(i<nums.length) 
        {
            if(!s.isEmpty())
            {
                if(nums[s.peek()]>=nums[i])
                {
                    s.push(i);
                }else
                {
                    answer[s.pop()]=nums[i];
                    continue;
                }
            }else
            {
                s.push(i);
            }
            
            i++;
        }
        
        i=0;
        
        while(!s.isEmpty() && i<nums.length)
        {
            
            if(nums[i]>nums[s.peek()])
            {
                answer[s.pop()]=nums[i];
                
            }
            else
            {
                i++;
            }
        }
       
        while(!s.isEmpty())
            answer[s.pop()]=-1;
        
        return answer;
    }
}