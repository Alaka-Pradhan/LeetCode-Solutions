import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution { 
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int maxVal = 1000;
        int[] weights = new int[maxVal + 1];
        
        for (int[] item : items1) {
            weights[item[0]] += item[1];
        }
        
        for (int[] item : items2) {
            weights[item[0]] += item[1];
        }
        
        List<List<Integer>> result = new ArrayList<>(); 
        
        for (int value = 1; value <= maxVal; value++) { 
            if (weights[value] > 0) {
                result.add(Arrays.asList(value, weights[value]));
            }
        }
        
        return result;
    }
}
