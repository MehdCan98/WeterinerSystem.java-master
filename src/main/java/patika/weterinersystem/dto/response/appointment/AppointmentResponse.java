package patika.weterinersystem.dto.response.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.weterinersystem.entities.Animal;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private int id;
    private LocalDateTime appointmentDate;
    private Animal animal;
    private patika.weterinersystem.entities.Doctor doctor;
}
