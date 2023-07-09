package com.learning.springbootcrud.dao;

import com.learning.springbootcrud.entity.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDAO {
    private final EntityManager entityManager;

    public BookEntity save(BookEntity book) {
        entityManager.persist(book);
        return book;
    }

    public BookEntity findById(Long id) {
        return entityManager.find(BookEntity.class, id);
    }

    public List<BookEntity> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = cq.from(BookEntity.class);
        cq.select(root);
        TypedQuery<BookEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public void update(BookEntity book) {
        entityManager.merge(book);
    }

    public void delete(BookEntity book) {
        entityManager.remove(book);
    }
}
