package edu.famu.grubz.models.serializable;

import edu.famu.grubz.models.Taste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerializableGroup {
    private String hostId;
    private ArrayList<String> userIds;
    private String link;
    private String location;
    private String radius;
    private ArrayList<Taste> tastes;
    private @Nullable ArrayList<String> recommendations;
}
