class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0,j = 0,a = 0,b = 0,n = nums.length,k2 = 0;
        int count = 0;

        while(i<n && nums[i]%2==0) i++;
        while(j<n && k2<k) if(nums[j++]%2 != 0) k2++;
        if(k2<k) return 0;
        j--;

        b = j+1;
        while(b<n && nums[b]%2==0) b++;
        b--;
        while(b<n){
            count += (i-a+1)*(b-j+1);

            a = i+1;//a

            i++; while(i<n && nums[i]%2==0) i++;

            j = b+1;//j

            b = j+1;//b
            while(b<n && nums[b]%2==0) b++; b--;
        }
        return count;
    }
}