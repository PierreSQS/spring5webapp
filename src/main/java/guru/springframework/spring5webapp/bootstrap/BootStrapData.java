package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
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
        bookRepo.save(javaRecipes);
        bookRepo.save(springBootFundamentals);
        log.info("saved books {}", bookRepo.count());

    }
}