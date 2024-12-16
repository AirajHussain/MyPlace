package com.example.myplace.ui.mainpage;

public class RealEstate {
    private int id;
    private int eu_id;
    private String post_date;
    private int price;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String type;
    private int bedrooms;
    private float bathrooms;
    private int indoor_size;
    private int outdoor_size;
    private int garage;
    private String moveInDate;
    private int laundry;
    private int dishwasher;
    private int fridge;
    private int oven;
    private String heating;
    private String cooling;
    private byte[] image;

    public RealEstate(int id, int eu_id, String post_date, int price, String address, String city,
                      String province, String postalCode, String type, int bedrooms, float bathrooms,
                      int indoor_size, int outdoor_size, int garage, String moveInDate, int laundry,
                      int dishwasher, int fridge, int oven, String heating, String cooling,
                      byte[] image) {
        this.id = id;
        this.eu_id = eu_id;
        this.post_date = post_date;
        this.price = price;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.indoor_size = indoor_size;
        this.outdoor_size = outdoor_size;
        this.garage = garage;
        this.moveInDate = moveInDate;
        this.laundry = laundry;
        this.dishwasher = dishwasher;
        this.fridge = fridge;
        this.oven = oven;
        this.heating = heating;
        this.cooling = cooling;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getEu_id() {
        return eu_id;
    }

    public String getPost_date() {
        return post_date;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getType() {
        return type;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public float getBathrooms() {
        return bathrooms;
    }

    public int getIndoor_size() {
        return indoor_size;
    }

    public int getOutdoor_size() {
        return outdoor_size;
    }

    public int getGarage() {
        return garage;
    }

    public String getMoveInDate() {
        return moveInDate;
    }

    public int isLaundry() {
        return laundry;
    }

    public int isDishwasher() {
        return dishwasher;
    }

    public int isFridge() {
        return fridge;
    }

    public int isOven() {
        return oven;
    }

    public String getHeating() {
        return heating;
    }

    public String getCooling() {
        return cooling;
    }

    public byte[] getImage() {
        return image;
    }
}
