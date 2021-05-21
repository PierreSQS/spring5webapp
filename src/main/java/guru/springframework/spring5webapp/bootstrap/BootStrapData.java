package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepo;
// the Book-Repository is not need since CASCADE.ALL (s. Entities-Mappings)
//    private final BookRepository bookRepo;

    public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
//        this.bookRepo = bookRepo;
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

    }
}
