package com.crowdmarketing.model.requests;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Builder
@Data
public class SignupRequest {

    @Length(message = "Min length 3 and max 26 symbols.", min = 3, max = 26)
    private String firstName;

    @Length(message = "Min length 3 and max 26 symbols.", min = 3, max = 26)
    private String lastName;

    @Length(message = "Min length 3 and max 26 symbols.", min = 3, max = 26)
    private String username;

    @Email(message = "Email is not correct.")
    private String email;

    @Length(message = "Min length 5 symbols.", min = 5)
    private String password;
}
