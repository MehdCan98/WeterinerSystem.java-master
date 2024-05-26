package patika.weterinersystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Vet Clinic Management", version = "1.0", description = "Vet Clinic Project"))
public class VetClinicManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(VetClinicManagementApplication.class, args);
    }


    //Present By Mehdi CELİK

}
