package patika.weterinersystem.service.concretes;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.weterinersystem.core.config.modelMapper.IModelMapperService;
import patika.weterinersystem.core.exception.AlreadyExistException;
import patika.weterinersystem.core.exception.NotFoundException;
import patika.weterinersystem.core.utilies.Msg;
import patika.weterinersystem.dao.AppointmentRepo;
import patika.weterinersystem.dto.request.appointment.AppointmentSaveRequest;
import patika.weterinersystem.dto.request.appointment.AppointmentUpdateRequest;
import patika.weterinersystem.dto.response.appointment.AppointmentResponse;
import patika.weterinersystem.entities.Animal;
import patika.weterinersystem.entities.Appointment;
import patika.weterinersystem.entities.Doctor;
import patika.weterinersystem.service.abstracts.IAnimalService;
import patika.weterinersystem.service.abstracts.IAppointmentService;
import patika.weterinersystem.service.abstracts.IAvailableDateService;
import patika.weterinersystem.service.abstracts.IDoctorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentManager implements IAppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final IAnimalService animalService;
    private final IDoctorService doctorService;
    private final IAvailableDateService availableDateService;
    private final IModelMapperService modelMapper;

    public AppointmentManager(AppointmentRepo appointmentRepo, IAnimalService animalService, IDoctorService doctorService, IAvailableDateService availableDateService, IModelMapperService modelMapper) {
        this.appointmentRepo = appointmentRepo;
        this.animalService = animalService;
        this.doctorService = doctorService;
        this.availableDateService = availableDateService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Appointment getOne(int id) {
        return this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    //The process of checking for existing appointments and availability of the doctor when creating a new appointment(Değerlendirme Formu 18)
    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
        Optional<Appointment> checkAppointment = appointmentRepo.findByAppointmentDateAndDoctorId(appointmentSaveRequest.getAppointmentDate(), appointmentSaveRequest.getDoctorId());
        if (checkAppointment.isPresent()) {
            throw new AlreadyExistException(Msg.CONFLICT);
        }
        Appointment saveAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
        saveAppointment.setId(0);
        Animal animal = this.animalService.getOne(appointmentSaveRequest.getAnimalId());
        Doctor doctor = this.doctorService.getOne(appointmentSaveRequest.getDoctorId());
        saveAppointment.setDoctor(doctor);
        saveAppointment.setAnimal(animal);

        List<LocalDate> doctorAvailableDates = this.availableDateService.localDatesByDoctorId(doctor.getId());
        if (!doctorAvailableDates.contains(saveAppointment.getAppointmentDate().toLocalDate())) {
            throw new NotFoundException("Doktor bugün çalışmamaktadır.");
        }

        this.appointmentRepo.save(saveAppointment);
        return this.modelMapper.forResponse().map(saveAppointment, AppointmentResponse.class);
    }


    @Override
    public AppointmentResponse get(int id) {
        Appointment appointment = this.getOne(id);
        return this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
    }

    @Override
    public Page<AppointmentResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Appointment> appointmentPage = this.appointmentRepo.findAll(pageable);
        return appointmentPage.map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
    }

    @Override
    public AppointmentResponse update(AppointmentUpdateRequest appointmentUpdateRequest) {
        Optional<Appointment> checkAppointment = appointmentRepo.findByAppointmentDateAndDoctorId(appointmentUpdateRequest.getAppointmentDate(), appointmentUpdateRequest.getDoctorId());
        if (checkAppointment.isPresent()) {
            throw new AlreadyExistException(Msg.CONFLICT);
        }
        Appointment updateAppointment = this.modelMapper.forRequest().map(appointmentUpdateRequest, Appointment.class);
        Animal animal = this.animalService.getOne(appointmentUpdateRequest.getAnimalId());
        Doctor doctor = this.doctorService.getOne(appointmentUpdateRequest.getDoctorId());
        updateAppointment.setDoctor(doctor);
        updateAppointment.setAnimal(animal);

        List<LocalDate> doctorAvailableDates = this.availableDateService.localDatesByDoctorId(doctor.getId());
        if (!doctorAvailableDates.contains(updateAppointment.getAppointmentDate().toLocalDate())) {
            throw new NotFoundException("Doktor bugün çalışmamaktadır.");
        }

        this.appointmentRepo.save(updateAppointment);
        return this.modelMapper.forResponse().map(updateAppointment, AppointmentResponse.class);
    }

    @Override
    public List<AppointmentResponse> getDoctorsAppointment(LocalDate startDate, LocalDate finishDate, Doctor doctor) {

        LocalDateTime startDateTime = startDate.atTime(0, 0, 0);
        LocalDateTime finishDateTime = finishDate.atTime(0, 0, 0);

        List<AppointmentResponse> appointmentList = appointmentRepo.findAppointmentsByDateAndDoctor(startDateTime, finishDateTime, doctor).stream().map(appointment -> modelMapper.forResponse().map(appointment, AppointmentResponse.class)).collect(Collectors.toList());

        if (startDate.isAfter(finishDate)) {
            throw new NotFoundException("Başlangıç tarihi bitiş tarihinden sonra olmalı");
        }

        if (!appointmentList.isEmpty()) {
            return appointmentList;
        }
        throw new NotFoundException(startDate.toString() + " ile " + finishDate.toString() + " tarihleri arasında " + doctor.getName() + " isimli doktorun randevusu bulunmamaktadır!");

    }

    @Override
    public List<AppointmentResponse> getAnimalAppointments(LocalDate startDate, LocalDate finishDate, Animal animal) {
        LocalDateTime startDateTime = startDate.atTime(0, 0, 0);
        LocalDateTime finishDateTime = finishDate.atTime(0, 0, 0);

        List<AppointmentResponse> appointmentList = appointmentRepo.findAppointmentsByDateAndAnimal(startDateTime, finishDateTime, animal).stream().map(appointment -> modelMapper.forResponse().map(appointment, AppointmentResponse.class)).collect(Collectors.toList());

        if (startDate.isAfter(finishDate)) {
            throw new NotFoundException("Başlangıç tarihi bitiş tarihinden sonra olmalı");
        }

        if (!appointmentList.isEmpty()) {
            return appointmentList;
        }
        throw new NotFoundException(startDate.toString() + " ile " + finishDate.toString() + " tarihleri arasında " + animal.getName() + " isimli hayvanın randevusu bulunmamaktadır!");

    }


    @Override
    public boolean delete(int id) {
        Appointment appointment = this.getOne(id);
        this.appointmentRepo.delete(appointment);
        return true;
    }
}
