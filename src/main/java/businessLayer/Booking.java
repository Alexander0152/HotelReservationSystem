package businessLayer;

import java.util.Date;

public class Booking {
    private int id;
    private int roomNumber;
    private String customerName;
    private Date dateIn;
    private Date dateOut;
    private boolean separate;
    private int amountOfAdults;
    private int amountOfChildren;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }


    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;

    }

    public boolean getSeparate() {
        return separate;
    }

    public void setSeparate(boolean separate) {
        this.separate = separate;

    }

    public int getAmountOfAdults() {
        return amountOfAdults;
    }

    public void setAmountOfAdults(int amountOfAdults) {
        this.amountOfAdults = amountOfAdults;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }
}
