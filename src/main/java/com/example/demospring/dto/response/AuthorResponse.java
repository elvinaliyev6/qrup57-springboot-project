package com.example.demospring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorResponse {
    private Long id;
    private String name;
    private String surname;
    private Date dob;
}
