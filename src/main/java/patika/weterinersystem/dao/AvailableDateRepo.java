package patika.weterinersystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.entities.AvailableDate;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Integer> {
    Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, int doctorId);
}
