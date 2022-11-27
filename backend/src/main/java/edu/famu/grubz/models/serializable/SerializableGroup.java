package edu.famu.grubz.models.serializable;

import edu.famu.grubz.models.Member;
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
    private ArrayList<Member> members;
    private String location;
    private int radius;
    private @Nullable ArrayList<String> tastes;
}
