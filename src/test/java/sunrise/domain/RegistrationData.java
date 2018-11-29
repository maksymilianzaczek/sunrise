package sunrise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationData
{
    private String password;
    private String confirmPassword;
    private String lastName;

}