class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int a1 = 1; 
        int a2 = 2; 
        for (int i = 3; i <= n; i++) {
            int temp = a1 + a2;
            a1 = a2; 
            a2 = temp;
        }
        
        return a2;
    }
}
