package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookRepository bookRepo;

    @GetMapping("/templates/books")
    public String getBooks(Model model) {
        log.info("######## Entering BookController #######");
        model.addAttribute("templates/books", bookRepo.findAll());
        return "templates/books/books_list";
    }
}
