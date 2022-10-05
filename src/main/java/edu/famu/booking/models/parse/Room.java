package edu.famu.booking.models.parse;
import edu.famu.booking.models.RoomNumber;
import edu.famu.booking.models.serializable.SerializableRoom;
import org.parse4j.ParseClassName;
import org.json.JSONArray;
import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;

import java.util.ArrayList;

@ParseClassName("Room")
public class Room extends ParseObject {

    final static String ID = "id";

    final static String TITLE = "title";

    final static String PRICE = "price";

    final static String MAXPEOPLE = "maxPeople";

    final static String ROOMNUMBERS = "roomNumbers";

    public String getID() {
        return getString(ID);
    }
    public void setID(String id) {
        put(ID, id);
    }

    public String getTitle() {
        return getString(TITLE);
    }
    public void setTitle(String title) {
        put(TITLE, title);
    }

    public Double getPrice() {
        return getDouble(PRICE);
    }
    public void setPrice(Double price) {
        put(PRICE, price);
    }

    public int getMaxPeople() {
        return getInt(MAXPEOPLE);
    }
    public void setMaxPeople(String maxPeople) {
        put(MAXPEOPLE, maxPeople);
    }

    public ArrayList<RoomNumber> getRoomNumbers()
    {
        return (ArrayList<RoomNumber>) get(ROOMNUMBERS);
    }
    public void setRoomNumbers(ArrayList<RoomNumber> roomNumbers)
    {
        JSONArray items = new JSONArray();
        for(RoomNumber c : roomNumbers)
            items.put(c.getJSONObject());

        put(ROOMNUMBERS, items);
    }

    public SerializableRoom getSerializable() {
        return new SerializableRoom(getID(), getTitle(), getPrice(),
                getMaxPeople(), getRoomNumbers()
                );
    }
}
