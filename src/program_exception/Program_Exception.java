package program_exception;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exception.DomainException;

public class Program_Exception {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int number = ler.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(ler.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(ler.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(ler.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(ler.next());

            reservation.UpdateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch(ParseException e){
            System.out.println("Invadid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        }
    }

}
