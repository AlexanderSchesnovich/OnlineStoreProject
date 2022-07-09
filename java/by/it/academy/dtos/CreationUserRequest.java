package by.it.academy.dtos;

import by.it.academy.entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreationUserRequest {
    @NotBlank
    String login;
    @NotBlank
    String password;
    UserType userType;
}
