package Week1;

import java.util.Scanner;

public class FlightTicketCalculator {
    public static void main(String[] args) {
        // Scanner class has been defined.
        Scanner input = new Scanner(System.in);

        // Distance, age, trip type, age discount and ticket discount variables were defined.
        int distance,age,tripType;
        double ageDiscount = 0, ticketDiscount = 0;

        // Distance input received from the user.
        System.out.print("distance to travel : ");
        distance = input.nextInt();

        // The normal (non-discounted) ticket price was calculated according to the distance.
        double normalAmount = distance * 0.10;

        // Age entry has been received.
        System.out.print("how old are you : ");
        age = input.nextInt();

        if (age < 12) {
            ageDiscount = normalAmount * 0.50; // If you are under 12, get a 50% discount on a regular (non-discounted) ticket.
        }
        else if (age < 24) {
            ageDiscount = normalAmount * 0.10; // If you are under 24, get a 10% discount on a regular (non-discounted) ticket.
        }
        else if (age > 65) {
            ageDiscount = normalAmount * 0.30; // If you are over 65, get a 30% discount on a normal (non-discounted) ticket.
        }else {
            System.out.println("You entered incorrect data"); // If anything other than these conditions is entered (e.g. negative number), it will print that you have entered incorrect data.
        }

        // Trip type input received from the user
        System.out.print("your trip type (1 => one way  |  2 => round trip) : ");
        tripType = input.nextInt();
        if (tripType == 2){
            ticketDiscount = (normalAmount - ageDiscount) * 0.20; // apply 20% discount if trip type equals 2
        }

        if (distance < 0 || age < 0 || tripType != 1 && tripType != 2){
            // if distance is less than 0 or
            // if age is less than 0 or
            // if trip type is not equal to 1 and trip type is not equal to 2
            System.out.println("Error: Invalid input.");
            // print (Error: Invalid input.) to the screen.
        }else {
            System.out.println("Normal Amount : " + normalAmount);
            System.out.println("Age discount : " + ageDiscount);
            System.out.println("Discounted amount : " + (normalAmount - ageDiscount));
            System.out.println("Round Trip ticket discount : " + ticketDiscount);
            if (tripType == 1){
                System.out.println("Total Amount : " + ((normalAmount - ageDiscount) - ticketDiscount));
            }else {
                System.out.println("Total Amount : " + ((normalAmount - ageDiscount) - ticketDiscount) * 2 );
            }
        }
    }
}