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
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;
    public List<Author> getFilt1(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> dogCriteriaQuery =
                builder.createQuery(Author.class);
        Root<Author> root = dogCriteriaQuery.from(Author.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "firstName")));
        Query<Author> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
    public List<Author> getFilt2(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> dogCriteriaQuery =
                builder.createQuery(Author.class);
        Root<Author> root = dogCriteriaQuery.from(Author.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "middleName")));
        Query<Author> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
    public List<Author> getFilt3(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> dogCriteriaQuery =
                builder.createQuery(Author.class);
        Root<Author> root = dogCriteriaQuery.from(Author.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "lastName")));
        Query<Author> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
    public List<Author> getFiltDate(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> dogCriteriaQuery =
                builder.createQuery(Author.class);
        Root<Author> root = dogCriteriaQuery.from(Author.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "birthDate")));
        Query<Author> query = session.createQuery(dogCriteriaQuery);
        return query.getResultList();
    }
}