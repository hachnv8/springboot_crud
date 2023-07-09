package com.learning.springbootcrud.controller;

import com.learning.springbootcrud.dto.BookDTO;
import com.learning.springbootcrud.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.saveBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        BookDTO bookDTO = bookService.findBookById(id);
        if (bookDTO != null) {
            return ResponseEntity.ok(bookDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = bookService.findAllBooks();
        return ResponseEntity.ok(bookDTOs);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        bookDTO.setId(id);
        bookService.updateBook(bookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }
}
