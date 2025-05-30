package com.cydeo.dto;

import com.cydeo.enums.EducationLevel;
import com.cydeo.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO {

    @JsonIgnore
    private Long id;

    @NotBlank(message = "First name cannot be empty.")
    @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty.")
    @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters.")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty.")
    @Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits long.")
    private String phoneNumber;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 4, max = 20, message = "Username should be between 4 and 20 characters.")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 6, message = "Password should be minimum 6 characters long.")
    private String password;

    @Past(message = "Birthday should be in the past.")
    private LocalDate birthday;

    @NotNull(message = "Status cannot be null.")
    private Status status;

    @NotNull(message = "Education level cannot be null.")
    private EducationLevel educationLevel;

    @NotNull(message = "Address in general cannot be null")
    @Valid
    @JsonManagedReference(value = "teacher-address-reference")
    private AddressDTO address;

}
