package program_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program_Exception {

    public static void main(String[] args) throws ParseException {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = ler.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(ler.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(ler.next());

        if (!checkout.after(checkin)) {
            System.out.println("Error in reservarion: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(ler.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(ler.next());
            String error = reservation.UpdateDates(checkin, checkout);
            if(error != null){
                System.out.println("Error in reservation: "+error);
            } else{
                System.out.println("Reservation: " + reservation);
            }

        }

    }

}
