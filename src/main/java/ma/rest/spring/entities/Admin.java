package ma.rest.spring.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Admin") // Specify discriminator value for Admin
public class Admin extends User {
}