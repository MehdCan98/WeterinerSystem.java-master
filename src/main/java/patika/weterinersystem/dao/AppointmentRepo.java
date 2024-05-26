package patika.weterinersystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.entities.Animal;
import patika.weterinersystem.entities.Appointment;
import patika.weterinersystem.entities.Doctor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> findByAppointmentDateAndDoctorId(LocalDateTime localDateTime, int doctorId);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate BETWEEN ?1 AND ?2 AND a.doctor = ?3")
    List<Appointment> findAppointmentsByDateAndDoctor(LocalDateTime startDate, LocalDateTime finishDate, Doctor doctor);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate BETWEEN ?1 AND ?2 AND a.animal = ?3")
    List<Appointment> findAppointmentsByDateAndAnimal(LocalDateTime startDate, LocalDateTime finishDate, Animal animal);

}
