
import java.util.Scanner;


public class Numbers_In_Words {

    private static final String[] belowTen = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    // Array for numbers between 11 and 19
    private static final String[] belowTwenty = {
        "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    // Array for multiples of ten (20, 30, 40, etc.)
    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Array for powers of 1000 (Thousand, Million, Billion, etc.)
    private static final String[] thousands = {
        "", "Thousand", "Million", "Billion", "Trillion"
    };

            public static void main(String[] args) {
                // Scanner to get input from the user
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a number: ");
                long number = scanner.nextLong(); // Read the input number
                System.out.println(numberToWords(number)); // Call the numberToWords function and print the result
            }

    // Function to convert the number to words
    public static String numberToWords(long num) {
        if (num == 0) {
            return "Zero"; // If the number is zero, return "Zero"
        }

        int i = 0; // Initialize a counter to track the thousand, million, billion, etc.
        String result = ""; // String to store the final result

        // Loop until the number becomes zero
        while (num > 0) {
            // If the last 3 digits are not zero, convert them to words
            if (num % 1000 != 0) {
                result = convertHundreds((int) (num % 1000)) + thousands[i] + " " + result;
            }

            // Divide the number by 1000 to move to the next set of three digits
            num /= 1000;
            i++; // Increment the counter to move to the next scale (thousand, million, etc.)
        }

        return result.trim(); // Return the result, trimmed of any extra spaces at the ends
    }

    // Function to convert a number less than 1000 into words
    private static String convertHundreds(int num) {
        String result = ""; // String to store the words for the current group of digits

        // If the number is 100 or greater, handle the hundreds place
        if (num >= 100) {
            result += belowTen[num / 100] + " Hundred "; // Get the word for the hundreds place
            num %= 100; // Reduce the number to the remaining part (tens and ones)
        }

        // If the number is 20 or greater, handle the tens place
        if (num >= 20) {
            result += tens[num / 10] + " "; // Get the word for the tens place
            num %= 10; // Reduce the number to the remaining ones place
        }

        // If the number is between 10 and 19, handle the special case for numbers 11-19
        if (num >= 10) {
            result += belowTwenty[num - 10] + " "; // Get the word for numbers 11-19
        } else if (num > 0) {
            result += belowTen[num] + " "; // Get the word for numbers less than 10
        }

        return result; // Return the result
    }
}
