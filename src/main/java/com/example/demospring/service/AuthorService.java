package com.example.demospring.service;

import com.example.demospring.dto.request.AuthorRequest;
import com.example.demospring.dto.response.AuthorResponse;
import com.example.demospring.dto.response.BaseResponse;
import com.example.demospring.entity.Author;
import com.example.demospring.exception.BaseException;
import com.example.demospring.mapper.AuthorMapper;
import com.example.demospring.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public BaseResponse<List<AuthorResponse>> getAllAuthors() {
        List<Author> authorList = authorRepository.findAll();

        if (authorList.isEmpty() || authorList == null) {
            throw new BaseException("Author not found!");
        }
        List<AuthorResponse> authorResponses = authorList.stream()
                .map(author -> authorMapper.mapEntityToResponse(author))
                .collect(Collectors.toList());

        return BaseResponse.<List<AuthorResponse>>
                        builder()
                .data(authorResponses)
                .status("process success compiled")
                .build();

    }

    public BaseResponse insertAuthor(AuthorRequest authorRequest) {
        Author author=authorMapper.mapRequestToEntity(authorRequest);
        authorRepository.save(author);
        return BaseResponse.builder()
                .data(null)
                .status("process success compiled!")
                .build();
    }

}
