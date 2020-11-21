package businessLayer;

public class Room {
    private int id;
    private int number;
    private int amountOfAdults;
    private int amountOfChildren;
    private int amountOfRooms;
    private String type;
    private double priceForOneNight;
    private String imageSrc;

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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc=imageSrc;
    }

}
