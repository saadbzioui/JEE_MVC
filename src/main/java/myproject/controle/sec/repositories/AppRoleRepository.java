package myproject.controle.sec.repositories;

import myproject.controle.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
  AppRole findByRoleName(String roleName);
}
