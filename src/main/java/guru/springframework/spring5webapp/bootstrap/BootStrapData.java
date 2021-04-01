package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepo;

    private final BookRepository bookRepo;

    private final PublisherRepository publisherRepo;

    @Override
    public void run(String... args) throws Exception {
        Author kenKousen = new Author("Ken", "Kousen");
        Book javaRecipes = new Book("Java Recipes","131313");
        Book springBootFundamentals = new Book("Spring Boot Fundamentals","7574884");
        kenKousen.getBooks().add(javaRecipes);
        kenKousen.getBooks().add(springBootFundamentals);

        javaRecipes.getAuthors().add(kenKousen);
        springBootFundamentals.getAuthors().add(kenKousen);

        authorRepo.save(kenKousen);
        log.info("saved Author {}", kenKousen);

        bookRepo.save(javaRecipes);
        bookRepo.save(springBootFundamentals);
        log.info("saved books {}", bookRepo.count());

        Publisher publisher = new Publisher("Edition Sanaga", "Rue du Wouri", "Centre","45454");
        publisher.getBooks().add(javaRecipes);
        publisher.getBooks().add(springBootFundamentals);

        javaRecipes.setPublisher(publisher);
        springBootFundamentals.setPublisher(publisher);
        publisherRepo.save(publisher);
        log.info("saved Publisher {}",publisher);

    }
}