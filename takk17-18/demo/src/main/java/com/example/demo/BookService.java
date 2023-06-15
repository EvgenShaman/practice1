package com.example.demo;

import com.example.demo.Author;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public Author getAuthorByBook(Long dogId) {
        return session.createQuery("from Book where id =:id", Author.class)
                .setParameter("id",dogId).getSingleResult();
    }
    public List<Book> getFiltered(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> dogCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = dogCriteriaQuery.from(Book.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "name")));
        Query<Book> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
    public List<Book> getFiltDate(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> dogCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = dogCriteriaQuery.from(Book.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "creationDate")));
        Query<Book> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
}