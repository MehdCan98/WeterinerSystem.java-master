package patika.weterinersystem.dto.response.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.weterinersystem.entities.Appointment;
import patika.weterinersystem.entities.Customer;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private int id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private Customer customer;
    private List<patika.weterinersystem.entities.Vaccine> vaccineList;
    private List<Appointment> appointmentList;
}
