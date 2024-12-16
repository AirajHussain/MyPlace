package com.example.myplace.ui.mainpage;

public class Rental {
    private int id;
    private int ru_id;
    private String post_date;
    private int rent;
    private String rentPeriod;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String type;
    private int bedrooms;
    private float bathrooms;
    private int hydro;
    private int heat;
    private int water;
    private int wifi;
    private int parking;
    private String moveInDate;
    private int pets;
    private int smoking;
    private int size;
    private String furnished;
    private int laundry;
    private int dishwasher;
    private int fridge;
    private int oven;
    private int hasAC;
    private int outdoor;
    private byte[] image;

    // Constructor
    public Rental(int id, int ru_id, String post_date,  int rent,  String rentPeriod, String address,
                  String city, String province, String postalCode, String type, int bedrooms,
                  float bathrooms, int hydro, int heat, int water, int wifi,
                  int parking, String moveInDate, int pets, int smoking, int size,
                  String furnished, int laundry, int dishwasher, int fridge,
                  int oven, int hasAC, int outdoor, byte[] image) {
        this.id = id;
        this.ru_id = ru_id;
        this.post_date = post_date;
        this.rent = rent;
        this.rentPeriod = rentPeriod;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.hydro = hydro;
        this.heat = heat;
        this.water = water;
        this.wifi = wifi;
        this.parking = parking;
        this.moveInDate = moveInDate;
        this.pets = pets;
        this.smoking = smoking;
        this.size = size;
        this.furnished = furnished;
        this.laundry = laundry;
        this.dishwasher = dishwasher;
        this.fridge = fridge;
        this.oven = oven;
        this.hasAC = hasAC;
        this.outdoor = outdoor;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getU_id() {
        return ru_id;
    }

    public String getPost_date() {
        return post_date;
    }

    public int getRent() {
        return rent;
    }

    public String getRentPeriod() {
        return rentPeriod;
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

    public int isHydro() {
        return hydro;
    }

    public int isHeat() {
        return heat;
    }

    public int isWater() {
        return water;
    }

    public int isWifi() {
        return wifi;
    }

    public int getParking() {
        return parking;
    }

    public String getMoveInDate() {
        return moveInDate;
    }

    public int isPets() {
        return pets;
    }

    public int isSmoking() {
        return smoking;
    }

    public int getSize() {
        return size;
    }

    public String getFurnished() {
        return furnished;
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

    public int isHasAC() {
        return hasAC;
    }

    public int isOutdoor() {
        return outdoor;
    }

    public byte[] getImage() {
        return image;
    }
}
