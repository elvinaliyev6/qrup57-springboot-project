package com.example.demospring.controller;

import com.example.demospring.dto.request.AuthorRequest;
import com.example.demospring.dto.response.AuthorResponse;
import com.example.demospring.dto.response.BaseResponse;
import com.example.demospring.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors/")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("")
    public BaseResponse<List<AuthorResponse>> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("")
    public BaseResponse insertAuthor(@RequestBody @Valid AuthorRequest authorRequest){
        return authorService.insertAuthor(authorRequest);
    }


}
