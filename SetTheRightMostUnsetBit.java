public class Solution {
    public static int setBits(int N){
        // Write your code here.
        int pos = 0;
        int res = Integer.MAX_VALUE; 
        int shiftValue = 1 << pos;
        boolean hasZero = false;
        while(shiftValue < N) {
            res = N & shiftValue;
            if (res == 0) {
                hasZero = true;
                break;
            } else {
                shiftValue = 1 << ++pos;
            }
            
        }

        if (hasZero) return N | (1 << pos);

        return N;

        
    }
}
