package businessLayer;


import java.sql.Date;

public class Booking {
    private int id;
    private int roomNumber;
    private String customerName;
    private Date dateIn;
    private Date dateOut;
    private boolean separate;
    private int amountOfAdults;
    private int amountOfChildren;
    private int bookingNumber;

    private boolean breakfasts;
    private boolean allinclusive;
    private boolean champagne;
    private double totalCost;

    private String optionals;


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

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public boolean getBreakfasts() {
        return breakfasts;
    }

    public void setBreakfasts(boolean breakfasts) {
        this.breakfasts = breakfasts;
    }

    public boolean getAllInclusive() {
        return allinclusive;
    }

    public void setAllinclusive(boolean allinclusive) {
        this.allinclusive = allinclusive;
    }

    public boolean getChampagne() {
        return champagne;
    }

    public void setChampagne(boolean champagne) {
        this.champagne = champagne;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getOptionals() {
        return optionals;
    }

    public void setOptionals(String optionals) {
        this.optionals = optionals;
    }
}
