class Solution {
    public String reverseWords(String s) {
        String[] w = s.trim().split("\\s+");
        StringBuilder a = new StringBuilder();

        for (int i = w.length - 1; i >= 0; i--) {
            a.append(w[i]);

            if (i != 0)
               a.append(" ");
        }
       return a.toString();
    }
}