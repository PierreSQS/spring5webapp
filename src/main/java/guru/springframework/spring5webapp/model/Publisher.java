package guru.springframework.spring5webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String address, String state, String zip) {
        this.name = name;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }
}
