package com.example.demospring.mapper;

import com.example.demospring.dto.request.AuthorRequest;
import com.example.demospring.dto.response.AuthorResponse;
import com.example.demospring.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper {

    AuthorResponse mapEntityToResponse(Author author);

    Author mapRequestToEntity(AuthorRequest request);
}
