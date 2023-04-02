/**********************************************
Workshop 7
Course:JAC44 - Winter
Last Name:Zamani
First Name:Mohamad
ID:153110192
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2023.03.31
**********************************************/

package jac444zaa.workshop7;

//Part A

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Workshop7 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a file name for baby name ranking: ");
//        String fileName = scanner.nextLine();
//
//        List<String> boysNames = new ArrayList<>();
//        List<String> girlsNames = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split("\\s+");
//                boysNames.add(data[1]);
//                girlsNames.add(data[3]);
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading file: " + e.getMessage());
//            System.exit(1);
//        }
//
//        List<String> commonNames = new ArrayList<>();
//        for (String boyName : boysNames) {
//            if (girlsNames.contains(boyName)) {
//                commonNames.add(boyName);
//            }
//        }
//
//        System.out.println(commonNames.size() + " names used for both genders");
//        System.out.println("They are " + String.join(" ", commonNames));
//    }
//}


// Part B

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Workshop7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name for baby name ranking: ");
        String fileName = scanner.nextLine();

        List<String> boyNames = new ArrayList<>();
        List<String> girlNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                boyNames.add(parts[1]);
                girlNames.add(parts[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort all names for boys and girls
        List<String> sortedBoyNames = boyNames.stream().sorted().collect(Collectors.toList());
        List<String> sortedGirlNames = girlNames.stream().sorted().collect(Collectors.toList());

        // Find common names
        Set<String> commonNames = new HashSet<>(sortedBoyNames);
        commonNames.retainAll(sortedGirlNames);

        // Remove common names from both lists
        sortedBoyNames.removeAll(commonNames);
        sortedGirlNames.removeAll(commonNames);

        // Display the sorted names individually
        System.out.println("Sorted unique boy names:");
        displayNamesInColumns(sortedBoyNames, 5);

        System.out.println("\nSorted unique girl names:");
        displayNamesInColumns(sortedGirlNames, 5);

        // Sort removed names list
        List<String> sortedCommonNames = commonNames.stream().sorted().collect(Collectors.toList());

        // Display the number of common names removed
        System.out.println("\nNumber of common names removed: " + commonNames.size());
        System.out.println("Sorted common names removed:");
        displayNamesInColumns(sortedCommonNames, 5);
    }

    private static void displayNamesInColumns(List<String> names, int columns) {
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-15s", names.get(i));
            if ((i + 1) % columns == 0) {
                System.out.println();
            }
        }
    }
}
