package edu.famu.grubz.models.parse;
import edu.famu.grubz.models.serializable.SerializableGroup;
import edu.famu.grubz.models.Member;
import org.json.JSONArray;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

import java.util.ArrayList;

@ParseClassName("Group")
public class Group extends ParseObject {
    final static String HOSTID = "hostId";

    final static String MEMBERS = "members";

    final static String LOCATION = "location";

    final static String RADIUS = "radius";

    final static String TASTES = "tastes";


    public String getHostId() {
        return getString(HOSTID);
    }
    public void setHostId(String hostId) {
        put(HOSTID, hostId);
    }

    public ArrayList<Member> getMembers()
    {
        return (ArrayList<Member>) get(MEMBERS);
    }
    public void setMembers(ArrayList<Member> members)
    {

            JSONArray items = new JSONArray();
            for(Member c : members)
                items.put(c.getJSONObject());

            put(MEMBERS, items);
    }

    public String getLocation() {
        return getString(LOCATION);
    }
    public void setLocation(String location) {
        put(LOCATION, location);
    }

    public int getRadius() {
        return getInt(RADIUS);
    }
    public void setRadius(int radius) {
        put(RADIUS, radius);
    }


    public ArrayList<String> getTastes()
    {
        return (ArrayList<String>) get(TASTES);
    }
    public void setTastes(ArrayList<String> tastes)
    {
        put(TASTES, createJSONArray(tastes));
    }

    private JSONArray createJSONArray(ArrayList<?> arr)
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }

    public SerializableGroup getSerializable() {
        return new SerializableGroup(getObjectId(),
                getHostId(), getMembers(), getLocation(),
                getRadius(), getTastes()
        );

    }
}
