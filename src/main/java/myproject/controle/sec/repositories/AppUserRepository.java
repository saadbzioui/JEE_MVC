package myproject.controle.sec.repositories;

import myproject.controle.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
     AppUser findByUsername(String username);
}
