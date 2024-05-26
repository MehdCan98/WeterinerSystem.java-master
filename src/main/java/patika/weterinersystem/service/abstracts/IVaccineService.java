package patika.weterinersystem.service.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.vaccine.VaccineSaveRequest;
import patika.weterinersystem.dto.request.vaccine.VaccineUpdateRequest;
import patika.weterinersystem.dto.response.vaccine.VaccineResponse;
import patika.weterinersystem.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVaccineService {
    Vaccine getOne(int id);
    List<patika.weterinersystem.dto.response.vaccine.VaccineResponse> getByAnimalId(int id);
    List<patika.weterinersystem.dto.response.vaccine.VaccineResponse> getByProtectionFinishDate(LocalDate startDate, LocalDate endDate);
    patika.weterinersystem.dto.response.vaccine.VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    VaccineResponse get(int id);
    Page<VaccineResponse> cursor(int page, int pageSize);
    VaccineResponse update(VaccineUpdateRequest vaccineUpdateRequest);
    boolean delete(int id);
}
