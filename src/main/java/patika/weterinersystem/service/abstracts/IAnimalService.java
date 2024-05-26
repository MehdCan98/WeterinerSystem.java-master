package patika.weterinersystem.service.abstracts;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.animal.AnimalSaveRequest;
import patika.weterinersystem.dto.request.animal.AnimalUpdateRequest;
import patika.weterinersystem.dto.response.animal.AnimalResponse;
import patika.weterinersystem.entities.Animal;

import java.util.List;


@Repository
public interface IAnimalService {
    Animal getOne(int id);
    List<AnimalResponse> getByName(String name);
    List<AnimalResponse> getByCustomerName(String name);
    AnimalResponse save(AnimalSaveRequest animalSaveRequest);
    AnimalResponse get(int id);
    Page<AnimalResponse> cursor(int page, int pageSize);
    AnimalResponse update(AnimalUpdateRequest animalUpdateRequest);
    boolean delete(int id);


}
