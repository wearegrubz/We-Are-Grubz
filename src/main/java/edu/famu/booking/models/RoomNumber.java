package edu.famu.booking.models;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomNumber {
    private String id;
    private int number;
    private ArrayList<Date> unavailableDates;

    public JSONObject getJSONObject(){
        JSONObject obj = new JSONObject();
        obj.append("id", id);
        obj.append("number", number);
        obj.append("unavailableDates", unavailableDates);
        return obj;
    }
}
