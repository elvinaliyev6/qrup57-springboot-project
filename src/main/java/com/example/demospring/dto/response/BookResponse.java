package com.example.demospring.dto.response;

import com.example.demospring.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class BookResponse {
    private Long id;
    private String name;
    private String description;
    private Author author;

}
