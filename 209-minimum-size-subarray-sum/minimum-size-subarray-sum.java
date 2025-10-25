class Solution {
    public int minSubArrayLen(int t,int[] nums) {
        int n = nums.length;
        int i=0,j=0,sum = 0;

        while(j<n && sum<t){
            sum+=nums[j++];
        }

        j--;// j ek aage hoga above loop ke wajah se
        int minLen = Integer.MAX_VALUE;
        while(i<n && j<n){

            if(sum>=t) minLen = Math.min(minLen,j-i+1); // if sum >= target then only calc
            sum-=nums[i];
            i++;j++;// j++ is imp nahi to niche wale loop mai value dubara add hogi mere tau k bete ...... aur agar niche wala loop nahi chala to minus to ho hi raha hai
            
            while(j<n && sum<t){
                sum+=nums[j++];
            }
            j--;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}