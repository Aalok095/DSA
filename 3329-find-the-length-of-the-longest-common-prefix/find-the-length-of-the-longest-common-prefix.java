class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        for (int val : arr1) {
            while (!st.contains(val) && val > 0) {
                st.add(val);
                val = val / 10; 
            }
        }

        int result = 0; // LCP
        for (int num : arr2) {
            while (!st.contains(num) && num > 0) {
                num /= 10;  // Trim last digit
            }
            if (num > 0) {
                result = Math.max(result, (int) (Math.log10(num) + 1));
            }
        }
        return result;
    }
}