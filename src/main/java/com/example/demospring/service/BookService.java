package com.example.demospring.service;

import com.example.demospring.dto.request.BookRequest;
import com.example.demospring.dto.response.BaseResponse;
import com.example.demospring.dto.response.BookResponse;
import com.example.demospring.entity.Author;
import com.example.demospring.entity.Book;
import com.example.demospring.exception.BaseException;
import com.example.demospring.mapper.BookMapper;
import com.example.demospring.repository.AuthorRepository;
import com.example.demospring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BaseResponse<List<BookResponse>> getAllBooks() {
        List<Book> bookList=bookRepository.findAll();
        if(bookList.isEmpty() || bookList==null){
            throw new BaseException("Book not found!");
        }

        List<BookResponse> books=new ArrayList<>();
        for(Book book: bookList){
            BookResponse bookResponse=bookMapper.mapEntityToResponse(book);
            Author author=authorRepository.findById(book.getAuthor().getId())
                    .orElseThrow(() -> new BaseException("Author not found!"));
            bookResponse.setAuthor(author);
            books.add(bookResponse);
        }
        return BaseResponse.<List<BookResponse>>
                builder()
                .data(books)
                .status("process success compiled")
                .build();

    }

    public BaseResponse<List<BookResponse>> getAllBooksByAuthor(Long authorId) {
        Author author=authorRepository.findById(authorId)
                .orElseThrow(() -> new BaseException("Author not found!"));

        List<Book> bookList=bookRepository.findAllByAuthor(author);

        List<BookResponse> books=new ArrayList<>();
        for(Book book: bookList){
            BookResponse bookResponse=bookMapper.mapEntityToResponse(book);
            bookResponse.setAuthor(author);
            books.add(bookResponse);
        }
        return BaseResponse.<List<BookResponse>>
                        builder()
                .data(books)
                .status("process success compiled")
                .build();
    }

    public BaseResponse insertBook(BookRequest request) {
        Author author=authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new BaseException("Author not found!"));
        Book book=bookMapper.mapRequestToEntity(request);
        book.setAuthor(author);
        bookRepository.save(book);
        return BaseResponse.<List<BookResponse>>
                        builder()
                .data(null)
                .status("process success compiled")
                .build();
    }
}
