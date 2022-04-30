package myproject.controle;

import myproject.controle.entities.Patient;
import myproject.controle.repositories.PatientRepository;
import myproject.controle.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ControleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"ahmed",new Date(),false,112));
            patientRepository.save(new Patient(null,"youssef",new Date(),false,123));
             patientRepository.save(new Patient(null,"amine",new Date(),false,125));
            patientRepository.save(new Patient(null,"yassine",new Date(),false,150));
            patientRepository.save(new Patient(null,"younes",new Date(),true,105));
            patientRepository.save(new Patient(null,"othmane",new Date(),true,109));
            patientRepository.save(new Patient(null,"yassmine",new Date(),false,170));
            patientRepository.save(new Patient(null,"wiam",new Date(),true,125));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());

            });
        };

    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
         securityService.saveNewUser("saad","1234","1234");
         securityService.saveNewUser("yasmine","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("saad","ADMIN");
            securityService.addRoleToUser("saad","USER");
            securityService.addRoleToUser("yasmine","USER");
            securityService.addRoleToUser("hassan","USER");

        };
    }
}