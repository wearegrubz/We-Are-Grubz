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
    private String id;
    private String hostId;
    private @Nullable ArrayList<String> userIds;
    private String location;
    private int radius;
    private @Nullable ArrayList<Taste> tastes;
    private @Nullable ArrayList<String> recommendations;
}
