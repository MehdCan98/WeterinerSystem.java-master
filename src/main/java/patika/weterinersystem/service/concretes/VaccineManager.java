package patika.weterinersystem.service.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.weterinersystem.service.abstracts.IAnimalService;
import patika.weterinersystem.service.abstracts.IVaccineService;
import patika.weterinersystem.core.config.modelMapper.IModelMapperService;
import patika.weterinersystem.core.exception.AlreadyExistException;
import patika.weterinersystem.core.exception.NotFoundException;
import patika.weterinersystem.core.utilies.Msg;
import patika.weterinersystem.dao.VaccineRepo;
import patika.weterinersystem.dto.request.vaccine.VaccineSaveRequest;
import patika.weterinersystem.dto.request.vaccine.VaccineUpdateRequest;
import patika.weterinersystem.dto.response.vaccine.VaccineResponse;
import patika.weterinersystem.entities.Animal;
import patika.weterinersystem.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final IAnimalService animalService;
    private final IModelMapperService modelMapper;

    public VaccineManager(VaccineRepo vaccineRepo, IAnimalService animalService, IModelMapperService modelMapper) {
        this.vaccineRepo = vaccineRepo;
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Vaccine getOne(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    //Listing all vaccination records of a specific animal (all vaccination records of just one animal)(Değerlendirme Formu 24)
    @Override
    public List<VaccineResponse> getByAnimalId(int id) {
        List<VaccineResponse> vaccineResponseList = vaccineRepo.findVaccineByAnimalId(id)
                .stream()
                .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class)
                ).collect(Collectors.toList());

        if (!vaccineResponseList.isEmpty()) {
            return vaccineResponseList;
        }
        throw new NotFoundException(id + " ID'li hayvanın aşı bilgisi bulunmamaktadır!");
    }

    //Filtering by vaccination expiry date: the correct listing of vaccinations with expiry dates falling within the entered date range along with animal information(Değerlendirme Formu 23)
    @Override
    public List<VaccineResponse> getByProtectionFinishDate(LocalDate startDate, LocalDate endDate) {
        List<VaccineResponse> vaccineResponseList =  vaccineRepo.findByProtectionFinishDate(startDate,endDate)
                .stream()
                .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class)
                ).collect(Collectors.toList());

        if (startDate.isAfter(endDate)) {
            throw new NotFoundException("Başlangıç tarihi bitiş tarihinden önce olamaz");
        }

        if (!vaccineResponseList.isEmpty()) {
            return vaccineResponseList;
        }
        throw new NotFoundException(startDate.toString() + " ile " + endDate.toString() + " tarihleri arasında koruyuculuk bitiş tarihi olan aşı bulunmamaktadır!");
    }

    //Performing a check for vaccination expiry date during the process of saving a new vaccination record (Değerlendirme Formu 22)
    @Override
    public VaccineResponse save(VaccineSaveRequest vaccineSaveRequest) {
        Optional<Vaccine> checkVaccine = vaccineRepo.findByNameAndCodeAndAnimalIdAndProtectionStartDateAndProtectionFinishDate
                (
                        vaccineSaveRequest.getName(),
                        vaccineSaveRequest.getCode(),
                        vaccineSaveRequest.getAnimalId(),
                        vaccineSaveRequest.getProtectionStartDate(),
                        vaccineSaveRequest.getProtectionFinishDate()
                );

        if (checkVaccine.isPresent()) {
            throw new AlreadyExistException("Bu aşı zaten kayıtlı");
        }

        if (!vaccineSaveRequest.getProtectionFinishDate().isAfter(vaccineSaveRequest.getProtectionStartDate())) {
            throw new NotFoundException("Bitiş tarihi başlangıçtan ileri olamaz");
        }

        List<Vaccine> allVaccine = this.vaccineRepo.findByNameAndCodeAndAnimalId(vaccineSaveRequest.getName(), vaccineSaveRequest.getCode(), vaccineSaveRequest.getAnimalId());

        for (Vaccine vaccine : allVaccine) {
            if (!vaccineSaveRequest.getProtectionFinishDate().isAfter(vaccine.getProtectionStartDate())) { //vaccine.getProtectionStartDate().isAfter(vaccineSaveRequest.getProtectionFinishDate())
                throw new AlreadyExistException("Aşı Tarihi Dolmadı");
            }
            if (!vaccineSaveRequest.getProtectionStartDate().isAfter(vaccine.getProtectionFinishDate())) { //vaccine.getProtectionFinishDate().isAfter(vaccineSaveRequest.getProtectionFinishDate())
                throw new AlreadyExistException("Başlangıç tarihi diğer aşının bitiş tarihinden sonra olmalı");
            }
        }

        Vaccine saveVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        saveVaccine.setId(0);
        Animal animal = this.animalService.getOne(vaccineSaveRequest.getAnimalId());
        saveVaccine.setAnimal(animal);
        this.vaccineRepo.save(saveVaccine);
        return this.modelMapper.forResponse().map(saveVaccine, VaccineResponse.class);

    }

    @Override
    public VaccineResponse get(int id) {
        Vaccine vaccine = this.getOne(id);
        return this.modelMapper.forResponse().map(vaccine, VaccineResponse.class);
    }

    @Override
    public Page<VaccineResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Vaccine> vaccinepage = this.vaccineRepo.findAll(pageable);
        return vaccinepage.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    @Override
    public VaccineResponse update(VaccineUpdateRequest vaccineUpdateRequest) {

        Vaccine updateVaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest, Vaccine.class);
        Vaccine vaccine = this.getOne(vaccineUpdateRequest.getId());
        Animal animal = this.animalService.getOne(vaccineUpdateRequest.getAnimalId());
        updateVaccine.setAnimal(animal);
        updateVaccine.setProtectionStartDate(vaccine.getProtectionStartDate());
        updateVaccine.setProtectionFinishDate(vaccine.getProtectionFinishDate());
        this.vaccineRepo.save(updateVaccine);
        return this.modelMapper.forResponse().map(updateVaccine, VaccineResponse.class);

    }

    @Override
    public boolean delete(int id) {
        Vaccine vaccine = this.getOne(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }
}
