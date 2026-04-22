class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {

                int diff = 0;

                for (int k = 0; k < queries[i].length(); k++) {
                    if (queries[i].charAt(k) != dictionary[j].charAt(k)) {
                        diff++;
                    }
                    if (diff > 2) break;
                }

                if (diff <= 2) {
                    ans.add(queries[i]);
                    break;
                }
            }
        }

        return ans;
    }
}