package com.example.demo;

import com.example.demo.Author;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookRepository bookRepository;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AuthorRepository authorRepository;
    private final SessionFactory sessionFactory;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    private Session session;
    public List<Author> getFilt1(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> dogCriteriaQuery =
                builder.createQuery(Author.class);
        Root<Author> root = dogCriteriaQuery.from(Author.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "firstName")));
        Query<Author> query = session.createQuery(dogCriteriaQuery);
        log.info("filter_firstName");
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
        log.info("filter_middleName");
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
        log.info("filter_lastName");
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
        log.info("filter_birthDate");
        return query.getResultList();
    }
    @PostMapping(path="/add2") // Map ONLY POST Requests
    public @ResponseBody String addNewFood (@RequestParam String firstName, @RequestParam String lastName
            , @RequestParam String middleName, @RequestParam String birthDate) {
        Author n = new Author(firstName, lastName, middleName, birthDate, authorRepository.findAll().size());
        authorRepository.save(n);
        log.info("Add_Author");
        return "redirect:/catalogue";
    }
}