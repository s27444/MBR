package org.user.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.carrental.model.CarClass;
import org.carrental.model.CarStatus;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    private String firstName;

    private String lastName;

    private String number;

    private UserClass userClass;

    private UserStatus status;

}
