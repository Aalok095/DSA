class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] cumCount1 = new int[n];
        cumCount1[0] = s.charAt(0)=='1' ? 1 : 0;
        for(int i=1;i<n;i++){
            cumCount1[i] = cumCount1[i-1] + (s.charAt(i)=='1' ? 1 : 0);
        }

        int res = 0;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int oneCount = cumCount1[j] - (i>0 ? cumCount1[i-1] : 0);
                int zeroCount = (j-i+1) - oneCount;
                int z2 = zeroCount * zeroCount;

                //case 1
                if(z2 > oneCount){ // j ko daba k aage badaoo
                    int waste = z2 - oneCount;
                    j += waste-1;
                }
                // case 2
                else if(z2 == oneCount) res++;
                
                //case 3
                else {
                    res++;
                    int k = (int)Math.sqrt(oneCount) - zeroCount;
                    int next = j+k;
                    if(next>=n){
                        res += n-j-1;
                        break;
                    }
                    else res += k;
                    j = next;
                }
            }
        }
        return res;
    }
}