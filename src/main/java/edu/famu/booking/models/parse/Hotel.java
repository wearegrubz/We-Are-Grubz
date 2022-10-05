package edu.famu.booking.models.parse;

import edu.famu.booking.models.serializable.SerializableHotel;
import org.json.JSONArray;
import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;

import java.util.ArrayList;

@ParseClassName("Hotel")
public class Hotel extends ParseObject{

    final static String ID = "id";
    final static String NAME = "name";

    final static String TYPE = "type";

    final static String CITY = "city";

    final static String ADDRESS = "address";

    final static String DISTANCE = "distance";

    final static String PHOTOS = "photos";

    final static String TITLE = "title";

    final static String RATING = "rating";

    final static String ROOMS = "rooms";

    final static String CHEAPESTPRICE = "cheapestPrice";

    final static String FEATURED = "featured";

    public String getID() {
        return getString(ID);
    }
    public void setID(String id) {
        put(ID, id);
    }

    public String getName() {
        return getString(NAME);
    }
    public void setName(String name) {
        put(NAME, name);
    }

    public String getType() {
        return getString(TYPE);
    }
    public void setType(String type) {
        put(TYPE, type);
    }

    public String getCity() {
        return getString(CITY);
    }
    public void setCity(String city) {
        put(CITY, city);
    }

    public String getAddress() {
        return getString(ADDRESS);
    }
    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public String getDistance() {
        return getString(DISTANCE);
    }
    public void setDistance(String distance) {
        put(DISTANCE, distance);
    }

    public String getTitle() {
        return getString(TITLE);
    }
    public void setTitle(String title) {
        put(TITLE, title);
    }

    public int getRating() {
        return getInt(RATING);
    }
    public void setRating(int rating) {
        put(RATING, rating);
    }

    public double getCheapestPrice() {
        return getDouble(CHEAPESTPRICE);
    }
    public void setCheapestPrice(double cheapestPrice) {
        put(CHEAPESTPRICE, cheapestPrice);
    }

    public boolean getFeatured() {
        return getBoolean(FEATURED);
    }
    public void setFeatured(boolean featured) {
        put(FEATURED, featured);
    }


    public ArrayList<String> getPhotos()
    {
        return (ArrayList<String>) get(PHOTOS);
    }
    public void setPhotos(ArrayList<String> photos)
    {
        put(PHOTOS, createJSONArray(photos));
    }

    public ArrayList<Room> getRooms()
    {
        return (ArrayList<Room>) get(ROOMS);
    }
    public void setRooms(ArrayList<Room> rooms)
    {
        put(ROOMS, createJSONArray(rooms));
    }

    private JSONArray createJSONArray(ArrayList<?> arr )
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }

    public SerializableHotel getSerializable() {
        return new SerializableHotel(
                getID(), getName(), getType(), getCity(),
                getAddress(), getDistance(), getPhotos(), getTitle(),
                getRating(), getRooms(), getCheapestPrice(), getFeatured()
        );

    }


}
