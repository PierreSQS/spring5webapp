package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthorController {

    private final AuthorRepository authorRepo;

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        log.info("######## Entering AuthorController #######");
        model.addAttribute("authors", authorRepo.findAll());
        return "authors/authors_list";
    }
}
