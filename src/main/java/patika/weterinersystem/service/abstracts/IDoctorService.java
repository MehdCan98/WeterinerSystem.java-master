package patika.weterinersystem.service.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.doctor.DoctorSaveRequest;
import patika.weterinersystem.dto.request.doctor.DoctorUpdateRequest;
import patika.weterinersystem.dto.response.doctor.DoctorResponse;
import patika.weterinersystem.entities.AvailableDate;
import patika.weterinersystem.entities.Doctor;

import java.util.List;

@Repository
public interface IDoctorService {
    Doctor getOne(int id);
    DoctorResponse save(DoctorSaveRequest doctorSaveRequest);
    DoctorResponse get(int id);
    Page<DoctorResponse> cursor(int page, int pageSize);
    DoctorResponse update(DoctorUpdateRequest doctorUpdateRequest);
    boolean delete(int id);
    List<Doctor> getAll();
    List<AvailableDate> doctorAvailableDates(int id);
}
