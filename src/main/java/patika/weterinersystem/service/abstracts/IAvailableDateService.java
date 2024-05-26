package patika.weterinersystem.service.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.availableDate.AvailableDateSaveRequest;
import patika.weterinersystem.dto.request.availableDate.AvailableDateUpdateRequest;
import patika.weterinersystem.dto.response.availableDate.AvailableDateResponse;
import patika.weterinersystem.entities.AvailableDate;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAvailableDateService {
    AvailableDate getOne(int id);
    AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDateResponse get(int id);
    Page<AvailableDateResponse> cursor(int page, int pageSize);
    AvailableDateResponse update(AvailableDateUpdateRequest availableDateUpdateRequest);
    boolean delete(int id);
    List<LocalDate> localDatesByDoctorId(int id);
}
