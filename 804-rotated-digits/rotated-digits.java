class Solution {
    public int rotate(int n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int k = n % 10;
            if(k == 3 || k == 4 || k == 7) return -1;
            if(k == 0 || k == 1 || k == 8) sb.append(k);
            else if(k == 2) sb.append(5);
            else if(k == 5) sb.append(2);
            else if(k == 6) sb.append(9);
            else if(k == 9) sb.append(6);
            n /= 10;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public int rotatedDigits(int n) {
        int c = 0;
        for(int i = 1; i <= n; i++){
            int a = rotate(i);
            if(a!=-1 && a!=i) c++;  
        }
        return c;
    }
}