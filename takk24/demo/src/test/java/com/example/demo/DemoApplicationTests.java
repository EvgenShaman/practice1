package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Mock
	private BookRepository bookRepository;
	@Mock
	private AuthorRepository authorRepository;
	@Test
	public void doScheduledTask() {
		System.out.println("Scheduled task");
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("DBDir/authors.txt"), "utf-8"));
			String text = "";
			List<Book> ayaya = bookRepository.findAll();
			while (ayaya.size() != 0){
				text += ayaya.get(0).getName() + "\n";
				text += ayaya.get(0).getCreationDate() + "\n";
				text += ayaya.get(0).getAuthor().getFirstName() + "\n" + "\n";
				ayaya.remove(0);
			}
			writer.write(text);
		} catch (IOException ex) {
			// Report
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("DBDir/books.txt"), "utf-8"));
			String text = "";
			List<Author> ayaya = authorRepository.findAll();
			while (ayaya.size() != 0){
				text += ayaya.get(0).getFirstName() + "\n";
				text += ayaya.get(0).getMiddleName() + "\n";
				text += ayaya.get(0).getLastName() + "\n";
				text += ayaya.get(0).getBirthDate() + "\n" + "\n";
				ayaya.remove(0);
			}
			writer.write(text);
		} catch (IOException ex) {
			// Report
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
	@Test
	void contextLoads() {
	}


}
