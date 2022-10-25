package edu.famu.grubz.models.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableUser {
    private String name;
    private String username;
    private String email;
    private String password;
}
