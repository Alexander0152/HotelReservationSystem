package businessLayer;

import java.util.Date;

public class Booking {
    private int id;
    private int roomNumber;
    private String customerName;
    private Date dateIn;
    private Date dateOut;
    private boolean separate;

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
}
