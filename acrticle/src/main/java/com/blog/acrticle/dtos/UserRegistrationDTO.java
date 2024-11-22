package com.blog.acrticle.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3,message="Username must have atleast 3 characters")
    @Size(max = 20,message="Username must have almost 20 characters")
    private String userName;

    @Email(message = "Email is not valid format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10,max = 10,message = "Phone number must have 10 digits")
    @Pattern(regexp = "^[0-9]*$",message = "Phone number must contain only digits")
    private String phone;
}
