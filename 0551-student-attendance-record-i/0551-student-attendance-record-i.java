class Solution {
    public boolean checkRecord(String s) {
        int absences = 0;
        int consecutiveLates = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'A') {
                absences++;
                consecutiveLates = 0;
                }

            else if (c == 'L') {
                consecutiveLates++;
                } 

            else {
                consecutiveLates = 0; 
            }

            if (absences >= 2 || consecutiveLates >= 3) {
                return false;
            }
        }
        return true;
    }
}
