package IntegerToBinary;

import java.util.Scanner;

public class ConvertBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int decimal = scanner.nextInt();

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder); // Insert the remainder at the beginning
            decimal /= 2;
        }

        System.out.println("Binary representation: " + binary);
    }
}
