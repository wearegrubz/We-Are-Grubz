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
    private String groupId;
    private ArrayList<String> cuisines;

    public JSONObject getJSONObject(){
        JSONObject obj = new JSONObject();
        obj.append("userId", userId);
        obj.append("groupId", groupId);
        obj.append("cuisines", cuisines);
        return obj;
    }
}
