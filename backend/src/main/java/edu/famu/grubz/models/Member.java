package edu.famu.grubz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String name;
    private ArrayList<String> selections;
    public JSONObject getJSONObject(){
        JSONObject obj = new JSONObject();
        obj.append("name", name);
        obj.append("selections", selections);
        return obj;
    }
}
