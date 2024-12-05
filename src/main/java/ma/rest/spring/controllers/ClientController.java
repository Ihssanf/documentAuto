package ma.rest.spring.controllers;



import ma.rest.spring.entities.Client;
import ma.rest.spring.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Récupérer tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Récupérer un client par ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    // Créer un nouveau client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Mettre à jour un client existant
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setNom(clientDetails.getNom());
            client.setEmail(clientDetails.getEmail());
            client.setPassword(clientDetails.getPassword());
            return clientRepository.save(client);
        }
        return null;
    }

    // Supprimer un client par ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
