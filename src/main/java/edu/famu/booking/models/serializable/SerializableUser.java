package edu.famu.booking.models.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SerializableUser {
    private String id;
    private String username;
    private String email;
    private String country;
    private String img;
    private String city;
    private String phone;
    private boolean isAdmin;
}
