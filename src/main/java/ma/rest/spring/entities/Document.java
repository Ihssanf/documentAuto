package ma.rest.spring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateDeCreation;

    private String contexte;

    @ManyToOne
    @JoinColumn(name = "user_id") // This defines the foreign key column referencing the 'User' entity
    private User user;

    @ManyToOne
    private Modele modele;
}
