package ma.rest.spring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Use SINGLE_TABLE strategy
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING) // Column to differentiate user types
@Table(name = "app_user") // Use a single table for all user types
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Document> documents;
}