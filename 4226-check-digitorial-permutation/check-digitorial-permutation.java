class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i <= 9; i++) fact[i] = fact[i - 1] * i;
        

        int sum = 0;
        int temp = n;
        while (temp > 0) {
            sum += fact[temp % 10];
            temp /= 10;
        }

        String a = Integer.toString(n);
        String b = Integer.toString(sum);

        if (a.length() != b.length()) return false;

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);

        return Arrays.equals(ca,cb);
    }
}