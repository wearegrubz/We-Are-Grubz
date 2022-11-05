package edu.famu.grubz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taste {
    private String userId;
    private ArrayList<String> cuisines;

    public JSONObject getJSONObject(){
        JSONObject obj = new JSONObject();
        obj.append("userId", userId);
        obj.append("cuisines", cuisines);
        return obj;
    }
}
