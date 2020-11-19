package businessLayer;

public class Room {
    private int id;
    private int number;
    private int amountOfPersons;
    private int amountOfChildren;
    private int amountOfRooms;
    private String type;
    private double priceForOneNight;

    public Room(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number=number;
    }


    public int getAmountOfPersons() {
        return amountOfPersons;
    }

    public void setAmountOfPersons(int amountOfPersons) {
        this.amountOfPersons = amountOfPersons;
    }


    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }


    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public void setAmountOfRooms(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }


    public double getPriceForOneNight() {
        return priceForOneNight;
    }

    public void setPriceForOneNight(double priceForOneNight) {
        this.priceForOneNight=priceForOneNight;
    }

//    @Override
//    public String toString() {
//        return "Book: " + name + ' ' +
//                ", author " + author;
//    }
}
