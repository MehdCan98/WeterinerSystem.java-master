package patika.weterinersystem.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.weterinersystem.service.abstracts.IAnimalService;
import patika.weterinersystem.core.result.Result;
import patika.weterinersystem.core.result.ResultData;
import patika.weterinersystem.core.utilies.ResultHelper;
import patika.weterinersystem.dto.request.appointment.AppointmentSaveRequest;
import patika.weterinersystem.dto.request.appointment.AppointmentUpdateRequest;
import patika.weterinersystem.dto.response.CursorResponse;
import patika.weterinersystem.dto.response.appointment.AppointmentResponse;
import patika.weterinersystem.entities.Animal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final patika.weterinersystem.service.abstracts.IAppointmentService appointmentService;
    private final patika.weterinersystem.service.abstracts.IDoctorService doctorService;

    public AppointmentController(patika.weterinersystem.service.abstracts.IAppointmentService appointmentService, patika.weterinersystem.service.abstracts.IDoctorService doctorService, IAnimalService animalService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.animalService = animalService;
    }

    private final patika.weterinersystem.service.abstracts.IAnimalService animalService;


    // Değerlendirme Formu 17
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        return ResultHelper.created(this.appointmentService.save(appointmentSaveRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public patika.weterinersystem.core.result.ResultData<patika.weterinersystem.dto.response.appointment.AppointmentResponse> get(@PathVariable("id") int id) {
        return patika.weterinersystem.core.utilies.ResultHelper.success(this.appointmentService.get(id));
    }

    // Değerlendirme Formu 20
    @GetMapping("/doctor/{doctorId}/start-date/{startDateTime}/end-date/{finishDateTime}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getDoctorAppointments(@PathVariable("doctorId") int doctorId, @PathVariable("startDateTime") LocalDate startDateTime, @PathVariable("finishDateTime") LocalDate finishDateTime) {
        patika.weterinersystem.entities.Doctor doctor = this.doctorService.getOne(doctorId);
        return patika.weterinersystem.core.utilies.ResultHelper.success(this.appointmentService.getDoctorsAppointment(startDateTime, finishDateTime, doctor));
    }

    // Değerlendirme Formu 19
    @GetMapping("/animal/{animalId}/start-date/{startDateTime}/end-date/{finishDateTime}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getAnimalAppointments(@PathVariable("animalId") int animalId, @PathVariable("startDateTime") LocalDate startDateTime, @PathVariable("finishDateTime") LocalDate finishDateTime) {
        Animal animal = this.animalService.getOne(animalId);
        return ResultHelper.success(this.appointmentService.getAnimalAppointments(startDateTime, finishDateTime, animal));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AppointmentResponse>> cursor(@RequestParam(name = "size", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return ResultHelper.cursor(this.appointmentService.cursor(page, pageSize));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest) {
        this.appointmentService.getOne(appointmentUpdateRequest.getId());
        return ResultHelper.success(this.appointmentService.update(appointmentUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.appointmentService.delete(id);
        return ResultHelper.ok();
    }
}
