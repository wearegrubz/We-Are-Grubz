package edu.famu.grubz.models.parse;
import edu.famu.grubz.models.serializable.SerializableUser;
import org.parse4j.ParseClassName;
import org.parse4j.ParseUser;

@ParseClassName("User")
public class User extends ParseUser {
    final static String name = "name";
    final static String email = "email";
    final static String username = "username";
    final static String password = "password";

    public String getName() {
        return getString(name);
    }

    public String getUsername() {
        return getString(username);
    }
    public String getEmail() { return getString(email); }
    public String getPassword() {
        return getString(password);
    }

    public SerializableUser getSerializable() {
        return new SerializableUser(getObjectId(), getName(), getUsername(), getEmail(),
                getPassword()
        );
    }
}
