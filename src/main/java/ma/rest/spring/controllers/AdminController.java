package ma.rest.spring.controllers;



import ma.rest.spring.entities.Admin;
import ma.rest.spring.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Récupérer tous les administrateurs
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Récupérer un administrateur par ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Créer un nouvel administrateur
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // Mettre à jour un administrateur existant
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setNom(adminDetails.getNom());
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            return adminRepository.save(admin);
        }
        return null;
    }

    // Supprimer un administrateur par ID
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }
}
