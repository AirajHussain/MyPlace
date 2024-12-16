package com.example.myplace;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myplace.ui.mainpage.RentalsFragment;

public class DBHandler extends SQLiteOpenHelper {
    // DB variables
    private static final String DATABASE_NAME = "myPlace_db";
    private static int DATABASE_VERSION = 1;

    // Users table constant strings
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_U_ID = "u_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "pwd";
    private static final String COLUMN_FNAME = "first_name";
    private static final String COLUMN_LNAME = "last_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";

    // Rentals table constant strings
    private static final String TABLE_RENTALS = "rentals";
    private static final String COLUMN_R_ID = "r_id";
    private static final String COLUMN_RU_ID = "ru_id";
    private static final String COLUMN_R_POST_DATE = "r_post_date";
    private static final String COLUMN_RENT = "rent";
    private static final String COLUMN_RENT_PERIOD = "rent_period";
    private static final String COLUMN_R_ADDRESS = "r_address";
    private static final String COLUMN_R_CITY = "r_city";
    private static final String COLUMN_R_PROVINCE = "r_province";
    private static final String COLUMN_R_POSTAL = "r_postal";
    private static final String COLUMN_R_TYPE = "r_type";
    private static final String COLUMN_R_BEDROOMS = "r_bedrooms";
    private static final String COLUMN_R_BATHROOMS = "r_bathrooms";
    private static final String COLUMN_UTIL_HYDRO = "util_hydro";
    private static final String COLUMN_UTIL_HEAT = "util_heat";
    private static final String COLUMN_UTIL_WATER = "util_water";
    private static final String COLUMN_WIFI = "wifi";
    private static final String COLUMN_PARKING = "r_parking";
    private static final String COLUMN_R_MOVE_IN = "r_move_in";
    private static final String COLUMN_PETS = "pets";
    private static final String COLUMN_SMOKING = "smoking";
    private static final String COLUMN_R_SIZE = "r_size";
    private static final String COLUMN_FURNISHED = "furnished";
    private static final String COLUMN_R_APP_LAUNDRY = "r_app_laundry";
    private static final String COLUMN_R_APP_DISHWASHER = "r_app_dishwasher";
    private static final String COLUMN_R_APP_FRIDGE = "r_app_fridge";
    private static final String COLUMN_R_APP_OVEN = "r_app_oven";
    private static final String COLUMN_AC = "ac";
    private static final String COLUMN_OUTDOOR = "outdoor";
    private static final String COLUMN_R_IMAGE = "r_image";

    // Real estate constant strings
    private static final String TABLE_ESTATES = "estates";
    private static final String COLUMN_E_ID = "e_id";
    private static final String COLUMN_EU_ID = "eu_id";
    private static final String COLUMN_E_POST_DATE = "e_post_date";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_E_ADDRESS = "e_address";
    private static final String COLUMN_E_CITY = "e_city";
    private static final String COLUMN_E_PROVINCE = "e_province";
    private static final String COLUMN_E_POSTAL = "e_postal";
    private static final String COLUMN_E_TYPE = "e_type";
    private static final String COLUMN_E_BEDROOMS = "e_bedrooms";
    private static final String COLUMN_E_BATHROOMS = "e_bathrooms";
    private static final String COLUMN_INDOOR_SIZE = "indoor_size";
    private static final String COLUMN_OUTDOOR_SIZE = "outdoor_size";
    private static final String COLUMN_GARAGE = "garage";
    private static final String COLUMN_E_MOVE_IN = "e_move_in";
    private static final String COLUMN_E_APP_LAUNDRY = "e_app_laundry";
    private static final String COLUMN_E_APP_DISHWASHER = "e_app_dishwasher";
    private static final String COLUMN_E_APP_FRIDGE = "e_app_fridge";
    private static final String COLUMN_E_APP_OVEN = "e_app_oven";
    private static final String COLUMN_HEATING = "heating";
    private static final String COLUMN_COOLING = "cooling";
    private static final String COLUMN_E_IMAGE = "e_image";

    // DBHandler constructor
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create DB and all tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + " ("
                + COLUMN_U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " TEXT NOT NULL,"
                + COLUMN_PASSWORD + " TEXT NOT NULL, "
                + COLUMN_FNAME + " TEXT NOT NULL, "
                + COLUMN_LNAME + " TEXT NOT NULL, "
                + COLUMN_EMAIL + " TEXT NOT NULL, "
                + COLUMN_PHONE + " TEXT NOT NULL)";
        db.execSQL(CREATE_USER_TABLE);

        // Create rentals table
        String CREATE_RENTALS_TABLE = "CREATE TABLE " + TABLE_RENTALS + " ("
                + COLUMN_R_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RU_ID + " INTEGER NOT NULL, "
                + COLUMN_R_POST_DATE + " TEXT NOT NULL, " // date format
                + COLUMN_RENT + " INT NOT NULL, "
                + COLUMN_RENT_PERIOD + " TEXT NOT NULL, "
                + COLUMN_R_ADDRESS + " TEXT NOT NULL, "
                + COLUMN_R_CITY + " TEXT NOT NULL, "
                + COLUMN_R_PROVINCE + " TEXT NOT NULL, "
                + COLUMN_R_POSTAL + " TEXT NOT NULL, "
                + COLUMN_R_TYPE + " TEXT, "
                + COLUMN_R_BEDROOMS + " INT NOT NULL, "
                + COLUMN_R_BATHROOMS + " REAL NOT NULL, " // real for half baths
                + COLUMN_UTIL_HYDRO + " INT, " // boolean
                + COLUMN_UTIL_HEAT + " INT, " // boolean
                + COLUMN_UTIL_WATER + " INT, " // boolean
                + COLUMN_WIFI + " INT, " // boolean
                + COLUMN_PARKING + " INT, "
                + COLUMN_R_MOVE_IN + " TEXT NOT NULL, " // date format
                + COLUMN_PETS + " INT, " // boolean
                + COLUMN_SMOKING + " INT, " // boolean
                + COLUMN_R_SIZE + " INT, "
                + COLUMN_FURNISHED + " TEXT, " // options: not, fully, partially
                + COLUMN_R_APP_LAUNDRY + " INT, " // boolean
                + COLUMN_R_APP_DISHWASHER + " INT, " // boolean
                + COLUMN_R_APP_FRIDGE + " INT, " // boolean
                + COLUMN_R_APP_OVEN + " INT, " // boolean
                + COLUMN_AC + " INT, " // boolean
                + COLUMN_OUTDOOR + " INT, " // boolean
                + COLUMN_R_IMAGE + " BLOB, "
                + "FOREIGN KEY(ru_id) REFERENCES users(u_id))";

        db.execSQL(CREATE_RENTALS_TABLE);

        // Create real estate table
        String CREATE_ESTATES_TABLE = "CREATE TABLE " + TABLE_ESTATES + " ("
                + COLUMN_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EU_ID + " INTEGER NOT NULL, "
                + COLUMN_E_POST_DATE + " TEXT NOT NULL, " // date format
                + COLUMN_PRICE + " INT NOT NULL, "
                + COLUMN_E_ADDRESS + " TEXT NOT NULL, "
                + COLUMN_E_CITY + " TEXT NOT NULL, "
                + COLUMN_E_PROVINCE + " TEXT NOT NULL, "
                + COLUMN_E_POSTAL + " TEXT NOT NULL, "
                + COLUMN_E_TYPE + " TEXT, "
                + COLUMN_E_BEDROOMS + " INT NOT NULL, "
                + COLUMN_E_BATHROOMS + " REAL NOT NULL, " // real for half baths
                + COLUMN_INDOOR_SIZE + " INT, "
                + COLUMN_OUTDOOR_SIZE + " INT, "
                + COLUMN_GARAGE + " INT, "
                + COLUMN_E_MOVE_IN + " TEXT NOT NULL, " // date format
                + COLUMN_E_APP_LAUNDRY + " INT, " // boolean
                + COLUMN_E_APP_DISHWASHER + " INT, " // boolean
                + COLUMN_E_APP_FRIDGE + " INT, " // boolean
                + COLUMN_E_APP_OVEN + " INT, " // boolean
                + COLUMN_HEATING + " TEXT, "
                + COLUMN_COOLING + " TEXT, "
                + COLUMN_E_IMAGE + " BLOB, "
                + "FOREIGN KEY(eu_id) REFERENCES users(u_id))";
        db.execSQL(CREATE_ESTATES_TABLE);
    }

    // Pull single entry from any table with its table name and id
    public Cursor getEntryById(String table, int id) {
        String idName = "";
        switch (table) {
            case "users": idName = "u_id"; break;
            case "rentals": idName = "r_id"; break;
            case "estates": idName = "e_id"; break;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT DISTINCT * FROM " + table + " WHERE " + idName + " = " + id;
        return db.rawQuery(query, null);
    }

    public Cursor filterRentals (String sortBy, int rent_min, int rent_max,
                          String r_city, String r_province, String r_type, int r_bedrooms,
                          String r_bedrooms_operator, float r_bathrooms, String r_bathrooms_operator,
                          String r_move_in, String furnished) {
        // Open database
        SQLiteDatabase db = this.getReadableDatabase();

        // Create query string
        String query = "SELECT * FROM rentals WHERE";
        query += " rent BETWEEN " + rent_min + " AND " + rent_max;
        if (r_city != null) {
            query += " AND r_city = " + r_city;
        }
        if (r_province != null) {
            query += " AND r_province = " + r_province;
        }
        if (r_type != null) {
            query += " AND r_type = " + r_type;
        }
        query += " AND r_bedrooms " + r_bedrooms_operator + " " + r_bedrooms;
        query += " AND r_bathrooms " + r_bathrooms_operator + " " + r_bathrooms;
        if (r_move_in != null) {
            query += " AND r_move_in >= " + r_move_in;
        }
        if (furnished != null) {
            query += " AND furnished = " + furnished;
        }
        query += " ORDER BY " + sortBy + " DESC";

        // Return query
        return db.rawQuery(query, null);
    }

    public Cursor filterEstates (String sortBy, int price_min, int price_max, String e_city,
                          String e_province, String e_type, int e_bedrooms, float e_bathrooms,
                          String e_bedrooms_operator, String e_bathrooms_operator,
                          int indoor_size_min, int indoor_size_max, int outdoor_size_min,
                          int outdoor_size_max, int garage, String e_move_in) {
        // Open database
        SQLiteDatabase db = this.getReadableDatabase();

        // Create query string
        String query = "SELECT * FROM rentals WHERE";
        query += " rent BETWEEN " + price_min + " AND " + price_max;
        if (e_city != null) {
            query += " AND e_city = " + e_city;
        }
        if (e_province != null) {
            query += " AND e_province = " + e_province;
        }
        if (e_type != null) {
            query += " AND e_type = " + e_type;
        }
        query += " AND e_bedrooms " + e_bedrooms_operator + " " + e_bedrooms;
        query += " AND e_bathrooms " + e_bathrooms_operator + " " + e_bathrooms;
        query += " AND indoor_size BETWEEN " + indoor_size_min + " AND " + indoor_size_max;
        query += " AND outdoor_size BETWEEN " + outdoor_size_min + " AND " + outdoor_size_max;
        query += " AND garage = " + garage;
        if (e_move_in != null) {
            query += " AND e_move_in >= " + e_move_in;
        }
        query += " ORDER BY " + sortBy + " DESC";

        // Return query
        return db.rawQuery(query, null);
    }


    //getting entire db
    public Cursor showAll (String table, String sortBy) {
        // Open database
        SQLiteDatabase db = this.getReadableDatabase();

        // Create query string
        String query = "SELECT * FROM " + table + " ORDER BY " + sortBy + " DESC";

        // Return query
        return db.rawQuery(query, null);
    }

    //getting estates table only
    public Cursor showAllRentals() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_RENTALS + " ORDER BY " + COLUMN_RENT + " DESC"; // Sort by price or any other column
        return db.rawQuery(query, null);
    }

    public Cursor showAllRealEstate() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_ESTATES + " ORDER BY " + COLUMN_PRICE + " DESC"; // Sort by price or any other column
        return db.rawQuery(query, null);
    }

    public Cursor showAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " ORDER BY " + COLUMN_U_ID + " DESC"; // Sort by price or any other column
        return db.rawQuery(query, null);
    }

    // Upgrade DB from old version number to new version number
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        if (DATABASE_VERSION == oldVer) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RENTALS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESTATES);
            DATABASE_VERSION = newVer;
            onCreate(db);
        }
    }

    // Add a user to the DB
    public long addUser(String username, String pwd, String first_name, String last_name,
                        String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, pwd);
        values.put(COLUMN_FNAME, first_name);
        values.put(COLUMN_LNAME, last_name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        return db.insert(TABLE_USERS, null, values);
    }

    // Add a rental to the DB
    public long addRental(int ru_id, String r_post_date, int rent, String rent_period,
                          String r_address, String r_city, String r_province, String r_postal,
                          String r_type, int r_bedrooms, float r_bathrooms, int util_hydro,
                          int util_heat, int util_water, int wifi, int parking,
                          String r_move_in, int pets, int smoking, int r_size, String furnished,
                          int r_app_laundry, int r_app_dishwasher, int r_app_fridge, int r_app_oven,
                          int ac, int outdoor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_RU_ID, ru_id);
        values.put(COLUMN_R_POST_DATE, r_post_date);
        values.put(COLUMN_RENT, rent);
        values.put(COLUMN_RENT_PERIOD, rent_period);
        values.put(COLUMN_R_ADDRESS, r_address);
        values.put(COLUMN_R_CITY, r_city);
        values.put(COLUMN_R_PROVINCE, r_province);
        values.put(COLUMN_R_POSTAL, r_postal);
        values.put(COLUMN_R_TYPE, r_type);
        values.put(COLUMN_R_BEDROOMS, r_bedrooms);
        values.put(COLUMN_R_BATHROOMS, r_bathrooms);
        values.put(COLUMN_UTIL_HYDRO, util_hydro);
        values.put(COLUMN_UTIL_HEAT, util_heat);
        values.put(COLUMN_UTIL_WATER, util_water);
        values.put(COLUMN_WIFI, wifi);
        values.put(COLUMN_PARKING, parking);
        values.put(COLUMN_R_MOVE_IN, r_move_in);
        values.put(COLUMN_PETS, pets);
        values.put(COLUMN_SMOKING, smoking);
        values.put(COLUMN_R_SIZE, r_size);
        values.put(COLUMN_FURNISHED, furnished);
        values.put(COLUMN_R_APP_LAUNDRY, r_app_laundry);
        values.put(COLUMN_R_APP_DISHWASHER, r_app_dishwasher);
        values.put(COLUMN_R_APP_FRIDGE, r_app_fridge);
        values.put(COLUMN_R_APP_OVEN, r_app_oven);
        values.put(COLUMN_AC, ac);
        values.put(COLUMN_OUTDOOR, outdoor);
        return db.insert(TABLE_RENTALS, null, values);
    }

    // Add real estate to the DB
    public long addEstate(int eu_id, String e_post_date, int price, String e_address, String e_city,
                          String e_province, String e_postal, String e_type, int e_bedrooms,
                          float e_bathrooms, int indoor_size, int outdoor_size, int garage,
                          String e_move_in, int e_app_laundry, int e_app_dishwasher,
                          int e_app_fridge, int e_app_oven, String heating, String cooling) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EU_ID, eu_id);
        values.put(COLUMN_E_POST_DATE, e_post_date);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_E_ADDRESS, e_address);
        values.put(COLUMN_E_CITY, e_city);
        values.put(COLUMN_E_PROVINCE, e_province);
        values.put(COLUMN_E_POSTAL, e_postal);
        values.put(COLUMN_E_TYPE, e_type);
        values.put(COLUMN_E_BEDROOMS, e_bedrooms);
        values.put(COLUMN_E_BATHROOMS, e_bathrooms);
        values.put(COLUMN_INDOOR_SIZE, indoor_size);
        values.put(COLUMN_OUTDOOR_SIZE, outdoor_size);
        values.put(COLUMN_GARAGE, garage);
        values.put(COLUMN_E_MOVE_IN, e_move_in);
        values.put(COLUMN_E_APP_LAUNDRY, e_app_laundry);
        values.put(COLUMN_E_APP_DISHWASHER, e_app_dishwasher);
        values.put(COLUMN_E_APP_FRIDGE, e_app_fridge);
        values.put(COLUMN_E_APP_OVEN, e_app_oven);
        values.put(COLUMN_HEATING, heating);
        values.put(COLUMN_COOLING, cooling);
        return db.insert(TABLE_ESTATES, null, values);
    }
}