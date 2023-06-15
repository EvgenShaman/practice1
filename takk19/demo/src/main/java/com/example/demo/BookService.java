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
public class BookService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookRepository bookRepository;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AuthorRepository authorRepository;
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public List<Book> getFiltered(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> dogCriteriaQuery =
                builder.createQuery(Book.class);
        Root<Book> root = dogCriteriaQuery.from(Book.class);
        dogCriteriaQuery.select(root).orderBy(builder.asc(root.get(
                "name")));
        Query<Book> query = session.createQuery(dogCriteriaQuery);
        log.info("filter_getDate");
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
        log.info("filter_creationDate");
        return query.getResultList();
    }
    @PostMapping(path="/add1") // Map ONLY POST Requests
    public @ResponseBody String addNewFood (@RequestParam String name
            , @RequestParam String creationDate , @RequestParam Long authorId) {

        Book n = new Book(name, creationDate, bookRepository.findAll().size());
        n.setAuthor(authorRepository.getReferenceById(authorId));
        bookRepository.save(n);
        log.info("Add_Book");
        return "redirect:/catalogue";
    }
}