package com.example.demospring.controller;

import com.example.demospring.dto.request.BookRequest;
import com.example.demospring.dto.response.BaseResponse;
import com.example.demospring.dto.response.BookResponse;
import com.example.demospring.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public BaseResponse<List<BookResponse>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{authorId}")
    public BaseResponse<List<BookResponse>> getAllBooksByAuthor(@PathVariable Long authorId){
        return bookService.getAllBooksByAuthor(authorId);
    }

    @PostMapping
    public BaseResponse insertBook(@RequestBody @Valid BookRequest request){
        return bookService.insertBook(request);
    }

}
