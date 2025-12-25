class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int ele : nums) xor ^= ele;
        int rightBitOff = xor & xor-1;
        int mask = xor ^ rightBitOff;
        int b1 = 0, b2 = 0;
        for(int ele : nums){
            if((mask & ele)==0) b1 ^= ele;
            else b2 ^= ele; 
        }
        return new int[]{b1,b2};
    }
}