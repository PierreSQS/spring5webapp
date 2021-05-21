package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepo;
    private final PublisherRepository publisherRepo;
    // Not in USE for saving, Since CASCADE.ALL on parent class Author
    private final BookRepository bookRepo;

    public BootStrapData(AuthorRepository authorRepo, PublisherRepository publisherRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
        this.bookRepo = bookRepo;
    }


    @Override
    public void run(String... args) {
        Author craigWalls = new Author();
        craigWalls.setFirstName("Craig");
        craigWalls.setLastName("Walls");

        Author kenKousen = new Author();
        kenKousen.setFirstName("Ken");
        kenKousen.setLastName("Kousen");

        Book book1 = new Book();
        book1.setIsbn("111111");
        book1.setTitle("Spring in Action 5th Edition");

        Book book2 = new Book();
        book2.setIsbn("222222");
        book2.setTitle("Spring in Action 4th Edition");

        Book book3 = new Book();
        book3.setIsbn("333333");
        book3.setTitle("Groovy Fundamentals");

        Book book4 = new Book();
        book4.setIsbn("444444");
        book4.setTitle("Java Recipes");

        craigWalls.setBooks(Arrays.asList(book1,book2));
        kenKousen.setBooks(Arrays.asList(book3,book4));

        book1.setAuthors(Collections.singletonList(craigWalls));

        book3.setAuthors(Collections.singletonList(kenKousen));

        authorRepo.save(craigWalls);
        authorRepo.save(kenKousen);
        log.info("#### Saved Authors {} ###",authorRepo.count());
        log.info("#### Saved Books over CASCADE.ALL in Author-Class {} ###",bookRepo.count());

        // Publisher
        Publisher publisher = new Publisher();
        publisher.setName("Oreilly");
        publisher.setCity("Boston");
        publisher.setAdressLine1("2 Avenue de Lafayette");
        publisher.setState("MA");
        publisher.setZipCode("02111");

        publisherRepo.save(publisher);
        log.info("####### Saved Publisher: {}",publisher);

    }
}
