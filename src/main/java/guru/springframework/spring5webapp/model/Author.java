package guru.springframework.spring5webapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private final String firstName;
    private final String lastName;

    @ManyToMany(mappedBy = "authors")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Set<Book> books = new HashSet<>();


}
