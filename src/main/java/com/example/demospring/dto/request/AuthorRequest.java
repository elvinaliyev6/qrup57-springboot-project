package com.example.demospring.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequest {

    @NotEmpty(message = "name can not be empty")
    @NotNull(message = "name can not be null")
    private String name;

    @NotEmpty(message = "surname can not be empty")
    @NotNull(message = "surname can not be null")
    private String surname;

    private Date dob;

}
