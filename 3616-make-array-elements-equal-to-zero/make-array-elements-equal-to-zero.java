class Solution {

    public boolean check(int[] nums,int c,int i,int dir){
        int idx = i,n = nums.length ;

        int[] temp = Arrays.copyOf(nums,nums.length);

        while(idx>=0 && idx<temp.length && c>0){

            if(temp[idx]>0){

                temp[idx]--;
                dir *= -1;// dir change hulaboo....hu .. hu hu .... 

                if(temp[idx]==0) c--;
            }

            idx += dir;
        }
        return c==0;// all must be zero
    }

    public int countValidSelections(int[] nums) {
        int res = 0;
        int n = nums.length;

        int c = 0;// count of non zero ele
        for(int i=0;i<n;i++) if(nums[i]!=0) c++;

        for(int i=0;i<n;i++){

            if(nums[i]==0){

                if(check(nums,c,i,-1)) res++;// -1 for left direction
                if(check(nums,c,i,1)) res++;// +1 for right direction;
            }
        }
        return res;
    }
}