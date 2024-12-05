package ma.rest.spring.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Client") // Specify discriminator value for Client
public class Client extends User {
}