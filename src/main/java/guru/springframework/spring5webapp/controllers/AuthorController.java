package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/authors")
    public String displayAuthors(Model model){
        model.addAttribute("authors",authorRepo.findAll());
        return "authors/authorslist";
    }
}
