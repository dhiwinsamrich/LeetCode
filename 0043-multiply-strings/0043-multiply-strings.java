class Solution {
    public String multiply(String num1, String num2) {
        // Calculate the lengths of the input strings
        int n1 = num1.length(), n2 = num2.length();
        
        // Array to store the products of digits
        int[] products = new int[n1 + n2];

        // Multiply each digit of num1 with each digit of num2
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                // Add the product to the corresponding position in the products array
                products[i + j + 1] += d1 * d2;
            }
        }

        // Process carries and finalize the products
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int temp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = temp;
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (int num : products) {
            sb.append(num);
        }

        // Remove leading zeros from the result
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return "0" if the result is empty, otherwise return the result string
        return sb.length() == 0 ? "0" : sb.toString();
    }
}