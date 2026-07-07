import java.util.HashMap;
import java.util.Map;

class Solution {

    public int getLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> elementToFreq = new HashMap<>();
            Map<Integer, Integer> freqToCount = new HashMap<>();

            for (int j = i; j < n; j++) {
                int num = nums[j];

                if (elementToFreq.containsKey(num)) {
                    int oldFreq = elementToFreq.get(num);

                    freqToCount.put(oldFreq, freqToCount.get(oldFreq) - 1);
                    if (freqToCount.get(oldFreq) == 0)
                        freqToCount.remove(oldFreq);

                    elementToFreq.put(num, oldFreq + 1);
                    freqToCount.put(oldFreq + 1,
                        freqToCount.getOrDefault(oldFreq + 1, 0) + 1);
                } else {
                    elementToFreq.put(num, 1);
                    freqToCount.put(1,
                        freqToCount.getOrDefault(1, 0) + 1);
                }

                if (elementToFreq.size() == 1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else if (freqToCount.size() == 2) {
                    int f1 = -1, f2 = -1;

                    for (int f : freqToCount.keySet()) {
                        if (f1 == -1)
                            f1 = f;
                        else
                            f2 = f;
                    }

                    if (f1 * 2 == f2 || f2 * 2 == f1)
                        maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}