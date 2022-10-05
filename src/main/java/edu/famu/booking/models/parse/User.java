package edu.famu.booking.models.parse;
import edu.famu.booking.models.RoomNumber;
import edu.famu.booking.models.serializable.SerializableRoom;
import edu.famu.booking.models.serializable.SerializableUser;
import org.parse4j.ParseClassName;
import org.json.JSONArray;
import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;

import java.util.ArrayList;

@ParseClassName("User")
public class User extends ParseObject {

    final static String ID = "id";

    final static String USERNAME = "username";

    final static String EMAIL = "email";

    final static String COUNTRY = "country";

    final static String IMG = "img";

    final static String CITY = "city";

    final static String PHONE = "phone";

    final static String ISADMIN = "isAdmin";

    public String getID() {
        return getString(ID);
    }
    public void setID(String id) {
        put(ID, id);
    }

    public String getUsername() {
        return getString(USERNAME);
    }
    public void setUsername(String username) {
        put(USERNAME, username);
    }

    public String getEmail() {
        return getString(EMAIL);
    }
    public void setEmail(String email) {
        put(EMAIL, email);
    }

    public String getCountry() {
        return getString(COUNTRY);
    }
    public void setCountry(String country) {
        put(COUNTRY, country);
    }

    public String getImg() {
        return getString(IMG);
    }
    public void setIMG(String img) {
        put(IMG, img);
    }

    public String getCity() {
        return getString(CITY);
    }
    public void setCity(String city) {
        put(CITY, city);
    }

    public String getPhone() {
        return getString(PHONE);
    }
    public void setPhone(String phone) {
        put(PHONE, phone);
    }

    public boolean getIsAdmin() {
        return getBoolean(ISADMIN);
    }
    public void setIsAdmin(boolean isAdmin) {
        put(ISADMIN, isAdmin);
    }

    public SerializableUser getSerializable() {
        return new SerializableUser(getID(), getUsername(), getEmail(),
                getCountry(), getImg(), getCity(), getPhone(), getIsAdmin()
        );
    }


}
