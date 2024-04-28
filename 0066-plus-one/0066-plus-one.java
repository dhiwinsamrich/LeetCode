class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] == 9 && n!=1 && n-2>=0 && digits[n-2] != 9) {
            digits[n-2]++;
            digits[n-1]=0;
            return digits;
        }
        else {
            int numOfNines = n-1;
            while(numOfNines >= 0 && digits[numOfNines] == 9) numOfNines--;
            if (numOfNines >= 0 && digits[numOfNines]!=9) {
                digits[numOfNines]++;
                numOfNines++;
                while (numOfNines< n) {
                    digits[numOfNines] = 0;
                    numOfNines++;
                }
                return digits;
            }
            else {
                int[] newDigits = new int[n+1];
                newDigits[0] = 1;
                for(int i = 1; i<newDigits.length; i++) {
                    newDigits[i] = 0;
                }
                return newDigits;
            }

        }
    }
}