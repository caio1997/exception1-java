package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int roomNumber;
    private Date checkin;
    private Date checkout;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){ 
    }
    
    public Reservation(int roomNumber, Date checkin, Date chackout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = chackout;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getChackout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
   }
    
    public void UpdateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return  "RoomNumber = " +
                roomNumber + 
                " - checkin = " + 
                sdf.format(checkin) +
                " - checkout = " +
                sdf.format(checkout) +
                " - "+
                duration() +
                " nights";
    }
    
    
   
}
