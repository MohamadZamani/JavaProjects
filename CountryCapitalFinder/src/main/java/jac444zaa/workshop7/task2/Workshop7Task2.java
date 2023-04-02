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

package jac444zaa.workshop7.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Workshop7Task2 {
    public static void main(String[] args) {
        Map<String, String> countryCapitalMap = new HashMap<>();
        fillCountryCapitalMap(countryCapitalMap);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a country name or type 'exit' to quit:");
            String country = scanner.nextLine().trim();

            if (country.equalsIgnoreCase("exit")) {
                break;
            }

            String capital = countryCapitalMap.get(country);
            if (capital != null) {
                System.out.println("The capital of " + country + " is " + capital + ".");
            } else {
                System.out.println("Country not found in the list.");
            }
        }

        scanner.close();
    }

    private static void fillCountryCapitalMap(Map<String, String> map) {
        map.put("USA", "Washington, D.C.");
        map.put("Canada", "Ottawa");
        map.put("Mexico", "Mexico City");
        map.put("Brazil", "Brasília");
        map.put("Argentina", "Buenos Aires");
        map.put("China", "Beijing");
        map.put("India", "New Delhi");
        map.put("Japan", "Tokyo");
        map.put("Russia", "Moscow");
        map.put("Germany", "Berlin");
        map.put("France", "Paris");
        map.put("United Kingdom", "London");
        map.put("Italy", "Rome");
        map.put("Australia", "Canberra");
        map.put("South Africa", "Pretoria");
        map.put("Nigeria", "Abuja");
        map.put("Egypt", "Cairo");
        map.put("Turkey", "Ankara");
        map.put("Iran", "Tehran");
        map.put("Israel", "Jerusalem");
        map.put("Indonesia", "Jakarta");
        map.put("South Korea", "Seoul");
        map.put("Saudi Arabia", "Riyadh");
        map.put("Spain", "Madrid");
        map.put("Sweden", "Stockholm");
    }
}



//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Workshop7 extends Application {
//
//    private Map<String, String> countryCapitalMap = new HashMap<>();
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        fillCountryCapitalMap();
//
//        GridPane gridPane = new GridPane();
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setPadding(new Insets(10, 10, 10, 10));
//        gridPane.setVgap(5);
//        gridPane.setHgap(5);
//
//        Label countryLabel = new Label("Enter a Country:");
//        TextField countryInput = new TextField();
//        Button searchButton = new Button("Search");
//        Label capitalLabel = new Label("Capital:");
//
//        TextField capitalOutput = new TextField();
//        capitalOutput.setEditable(false);
//
//        gridPane.add(countryLabel, 0, 0);
//        gridPane.add(countryInput, 1, 0);
//        gridPane.add(searchButton, 2, 0);
//        gridPane.add(capitalLabel, 0, 1);
//        gridPane.add(capitalOutput, 1, 1, 2, 1);
//
//        searchButton.setOnAction(e -> {
//            String country = countryInput.getText();
//            String capital = countryCapitalMap.get(country);
//            if (capital != null) {
//                capitalOutput.setText(capital);
//            } else {
//                capitalOutput.setText("Country not found");
//            }
//        });
//
//        primaryStage.setTitle("Country Capital");
//        primaryStage.setScene(new Scene(gridPane, 400, 150));
//        primaryStage.show();
//    }
//
//    private void fillCountryCapitalMap() {
//        countryCapitalMap.put("Iran", "Tehran");
//        countryCapitalMap.put("United States", "Washington, D.C.");
//        countryCapitalMap.put("Canada", "Ottawa");
//        countryCapitalMap.put("Germany", "Berlin");
//        countryCapitalMap.put("France", "Paris");
//        countryCapitalMap.put("United Kingdom", "London");
//        countryCapitalMap.put("Italy", "Rome");
//        countryCapitalMap.put("Russia", "Moscow");
//        countryCapitalMap.put("China", "Beijing");
//        countryCapitalMap.put("India", "New Delhi");
//        countryCapitalMap.put("Japan", "Tokyo");
//        countryCapitalMap.put("Australia", "Canberra");
//        countryCapitalMap.put("Brazil", "Brasília");
//        countryCapitalMap.put("Argentina", "Buenos Aires");
//        countryCapitalMap.put("Mexico", "Mexico City");
//        countryCapitalMap.put("Spain", "Madrid");
//        countryCapitalMap.put("South Korea", "Seoul");
//        countryCapitalMap.put("Turkey", "Ankara");
//        countryCapitalMap.put("Netherlands", "Amsterdam");
//        countryCapitalMap.put("Egypt", "Cairo");
//        countryCapitalMap.put("South Africa", "Pretoria");
//        countryCapitalMap.put("Sweden", "Stockholm");
//        countryCapitalMap.put("Switzerland", "Bern");
//        countryCapitalMap.put("Norway", "Oslo");
//    }
//}
