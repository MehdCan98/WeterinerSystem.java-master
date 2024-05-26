package patika.weterinersystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.entities.Doctor;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

    Optional<Doctor> findByNameAndMail(String name, String mail);
}
