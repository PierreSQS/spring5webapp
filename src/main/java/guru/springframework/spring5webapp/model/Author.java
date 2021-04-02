package guru.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
