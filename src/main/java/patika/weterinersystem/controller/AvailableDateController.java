package patika.weterinersystem.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import patika.weterinersystem.service.abstracts.IAvailableDateService;
import patika.weterinersystem.core.result.Result;
import patika.weterinersystem.core.result.ResultData;
import patika.weterinersystem.core.utilies.ResultHelper;
import patika.weterinersystem.dto.request.availableDate.AvailableDateSaveRequest;
import patika.weterinersystem.dto.request.availableDate.AvailableDateUpdateRequest;
import patika.weterinersystem.dto.response.CursorResponse;
import patika.weterinersystem.dto.response.availableDate.AvailableDateResponse;

@RestController
@RequestMapping("/v1/available-dates")
public class AvailableDateController {

    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    // Değerlendirme Formu 16
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        return ResultHelper.created(this.availableDateService.save(availableDateSaveRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.availableDateService.get(id));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AvailableDateResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return ResultHelper.cursor(this.availableDateService.cursor(page, pageSize));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest) {
        this.availableDateService.getOne(availableDateUpdateRequest.getId());
        return ResultHelper.success(this.availableDateService.update(availableDateUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.availableDateService.delete(id);
        return ResultHelper.ok();
    }

}
