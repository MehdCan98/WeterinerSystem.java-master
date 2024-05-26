package patika.weterinersystem.service.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.appointment.AppointmentSaveRequest;
import patika.weterinersystem.dto.request.appointment.AppointmentUpdateRequest;
import patika.weterinersystem.dto.response.appointment.AppointmentResponse;
import patika.weterinersystem.entities.Animal;
import patika.weterinersystem.entities.Doctor;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppointmentService {
    patika.weterinersystem.entities.Appointment getOne(int id);
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse get(int id);
    Page<AppointmentResponse> cursor(int page, int pageSize);
    AppointmentResponse update(AppointmentUpdateRequest appointmentUpdateRequest);
    List<AppointmentResponse> getDoctorsAppointment(LocalDate startDate, LocalDate finishDate, Doctor doctor);
    List<AppointmentResponse> getAnimalAppointments(LocalDate startDate, LocalDate finishDate, Animal animal);

    boolean delete(int id);
}
