package edu.famu.grubz.models.parse;
import edu.famu.grubz.models.serializable.SerializableGroup;
import edu.famu.grubz.models.Taste;
import org.json.JSONArray;
import org.parse4j.ParseObject;

import java.util.ArrayList;

public class Group extends ParseObject {
    final static String HOSTID = "hostId";

    final static String USERIDS = "userIds";

    final static String LINK = "link";

    final static String LOCATION = "location";

    final static String RADIUS = "radius";

    final static String TASTES = "tastes";

    final static String RECOMMENDATIONS = "recomendations";

    public String getHostId() {
        return getString(HOSTID);
    }
    public void setHostId(String hostId) {
        put(HOSTID, hostId);
    }

    public ArrayList<String> getUserIds()
    {
        return (ArrayList<String>) get(USERIDS);
    }
    public void setUserIds(ArrayList<String> userIds)
    {
        put(USERIDS, createJSONArray(userIds));
    }

    public String getLink() {
        return getString(LINK);
    }
    public void setLink(String link) {
        put(LINK, link);
    }

    public String getLocation() {
        return getString(LOCATION);
    }
    public void setLocation(String location) {
        put(LOCATION, location);
    }

    public String getRadius() {
        return getString(RADIUS);
    }
    public void setRadius(String radius) {
        put(RADIUS, radius);
    }


    public ArrayList<Taste> getTastes()
    {
        return (ArrayList<Taste>) get(TASTES);
    }
    public void setTastes(ArrayList<Taste> tastes)
    {
        put(TASTES, createJSONArray(tastes));
    }

    public ArrayList<String> getRecomendations()
    {
        return (ArrayList<String>) get(RECOMMENDATIONS);
    }
    public void setRecommendations(ArrayList<String> recommendations)
    {
        put(RECOMMENDATIONS, createJSONArray(recommendations));
    }
    private JSONArray createJSONArray(ArrayList<?> arr)
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }

    public SerializableGroup getSerializable() {
        return new SerializableGroup(
                getHostId(), getUserIds(), getLink(), getLocation(),
                getRadius(), getTastes(), getRecomendations()
        );

    }
}
