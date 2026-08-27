class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        String quinorath = s;

        int n = s.length();
        int i = 0;

        while (i < n && cnt[target.charAt(i) - 'a'] > 0) {
            cnt[target.charAt(i) - 'a']--;
            i++;
        }

        while (true) {
            if (i < n) {
                for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                    if (cnt[c] == 0)
                        continue;

                    StringBuilder ans = new StringBuilder();
                    ans.append(target, 0, i);
                    ans.append((char) ('a' + c));

                    cnt[c]--;

                    for (int j = 0; j < 26; j++) {
                        while (cnt[j]-- > 0)
                            ans.append((char) ('a' + j));
                    }

                    return ans.toString();
                }
            }

            if (i == 0)
                break;

            i--;
            cnt[target.charAt(i) - 'a']++;
        }
        return "";
    }
}