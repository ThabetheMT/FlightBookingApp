package com.business;

import java.util.Scanner;

public class Main {
    static final double EL_PRICE = 1200;
    static final double CPT_PRICE = 2500;
    static final double DBN_PRICE = 1800;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter destination,( CPT: Cape Town, DBN: Durban, EL: East London): ");
        String destination = scanner.nextLine().toUpperCase();
        while(!validateDestination(destination)){
            System.out.print("Enter destination,( CPT: Cape Town, DBN: Durban, EL: East London): ");
            destination = scanner.nextLine().toUpperCase();
        }
        System.out.print("Enter the flight type (S or s-Single ,R or r-Return): ");
        char type = Character.toUpperCase(scanner.next().charAt(0));
        double price = determinePrice(destination,type);

        System.out.print("Enter accumulated voyager miles: ");
        int miles = scanner.nextInt();

        double pointBalance = convertPoints(miles);
        int remainingPoints = 0;
        double amountDue = price;

        if(pointBalance > price){
            remainingPoints = (int) (pointBalance - price) * 2;
        }

        displayBooking(destination,miles,price,amountDue,pointBalance);

    }
    public static boolean validateDestination (String destination){
       if(destination.equalsIgnoreCase("EL")){
           return true;
       } else if (destination.equalsIgnoreCase("CPT")) {
           return true;
       } else return destination.equalsIgnoreCase("DBN");
    }
    public static double determinePrice (String destination, char type){
        type = Character.toLowerCase(type);
        switch (destination.toUpperCase()){
            case "EL":
                if(type == 's'){
                    return EL_PRICE;
                }else {
                    return EL_PRICE * 2;
                }
            case "CPT":
                if(type == 's'){
                    return CPT_PRICE;
                }else {
                    return CPT_PRICE * 2;
                }
            case "DBN":
                if(type == 's'){
                    return DBN_PRICE;
                }else {
                    return DBN_PRICE * 2;
                }
        }
        return 0;
    }
    public static double convertPoints(int mile){
        return (double) mile / 2;
    }
    public static void displayBooking(String destination, double mile, double price,double balanceDue, double pointBalance){
        System.out.println("Destination"+"\t"+"Voyager Miles"+"\t"+"Price"+"\t\t"+"Balance"+
                "\t\t"+"Balance points in Rands");
        System.out.println(destination +"\t\t\t"+ mile +"\t\t\t"+ price +"\t\t"+ balanceDue +"\t\t"+ pointBalance);
    }
}