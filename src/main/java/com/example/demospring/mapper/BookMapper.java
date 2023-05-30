package com.example.demospring.mapper;

import com.example.demospring.dto.request.BookRequest;
import com.example.demospring.dto.response.BookResponse;
import com.example.demospring.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

     Book mapRequestToEntity(BookRequest request);

     BookResponse mapEntityToResponse(Book book);
}
