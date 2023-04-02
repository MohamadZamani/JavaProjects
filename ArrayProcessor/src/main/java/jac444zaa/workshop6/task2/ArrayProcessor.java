/**********************************************
Workshop 6
Course:JAC44 - Winter
Last Name:Zamani
First Name:Mohamad
ID:153110192
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2023.03.29
**********************************************/
package jac444zaa.workshop6.task2;

import java.util.Scanner;

@FunctionalInterface
public interface ArrayProcessor {
    double apply(double[] array);

    public static void main(String[] args) {
        ArrayProcessor max = array -> {
            double maxValue = array[0];
            for (double value : array) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            return maxValue;
        };

        ArrayProcessor min = array -> {
            double minValue = array[0];
            for (double value : array) {
                if (value < minValue) {
                    minValue = value;
                }
            }
            return minValue;
        };

        ArrayProcessor sum = array -> {
            double total = 0;
            for (double value : array) {
                total += value;
            }
            return total;
        };

        ArrayProcessor average = array -> {
            double total = 0;
            for (double value : array) {
                total += value;
            }
            return total / array.length;
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        double[] array = new double[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.println("Max value: " + max.apply(array));
        System.out.println("Min value: " + min.apply(array));
        System.out.println("Sum: " + sum.apply(array));
        System.out.println("Average: " + average.apply(array));

        System.out.print("Enter a value to count its occurrences: ");
        double value = scanner.nextDouble();
        ArrayProcessor counter = counter(value);
        System.out.println("Occurrences of " + value + ": " + counter.apply(array));
    }

    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (double element : array) {
                if (element == value) {
                    count++;
                }
            }
            return count;
        };
    }
}

