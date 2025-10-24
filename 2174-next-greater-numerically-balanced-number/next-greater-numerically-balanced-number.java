class Solution {

    public boolean bal(int n){
        int[] freq = new int[10];

        while(n>0){
            freq[n%10]++;
            n/=10;
        }

        for(int d=0;d<10;d++){
            if(freq[d]>0 && freq[d]!=d) return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i <= 1224444;i++){// from constraints we get till where for loop runs
            if(bal(i)) return i;
        }
        return 69;
    }
}