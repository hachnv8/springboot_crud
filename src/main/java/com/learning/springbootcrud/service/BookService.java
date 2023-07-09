package com.learning.springbootcrud.service;

import com.learning.springbootcrud.dao.BookDAO;
import com.learning.springbootcrud.dto.BookDTO;
import com.learning.springbootcrud.entity.BookEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDAO bookDAO;

    public BookDTO saveBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setYear(bookDTO.getYear());
        bookDAO.save(bookEntity);
        bookDTO.setId(bookEntity.getId());
        return bookDTO;
    }

    public BookDTO findBookById(Long id) {
        BookEntity bookEntity = bookDAO.findById(id);
        if (bookEntity != null) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bookEntity.getId());
            bookDTO.setTitle(bookEntity.getTitle());
            bookDTO.setAuthor(bookEntity.getAuthor());
            bookDTO.setYear(bookEntity.getYear());
            return bookDTO;
        }
        return null;
    }

    public List<BookDTO> findAllBooks() {
        List<BookEntity> bookEntities = bookDAO.findAll();
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(bookEntity.getId());
            bookDTO.setTitle(bookEntity.getTitle());
            bookDTO.setAuthor(bookEntity.getAuthor());
            bookDTO.setYear(bookEntity.getYear());
            bookDTOs.add(bookDTO);
        }
        return bookDTOs;
    }

    public void updateBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookDAO.findById(bookDTO.getId());
        if (bookEntity != null) {
            bookEntity.setTitle(bookDTO.getTitle());
            bookEntity.setAuthor(bookDTO.getAuthor());
            bookEntity.setYear(bookDTO.getYear());
            bookDAO.update(bookEntity);
        }
    }

    public void deleteBookById(Long id) {
        BookEntity bookEntity = bookDAO.findById(id);
        if (bookEntity != null) {
            bookDAO.delete(bookEntity);
        }
    }
}
