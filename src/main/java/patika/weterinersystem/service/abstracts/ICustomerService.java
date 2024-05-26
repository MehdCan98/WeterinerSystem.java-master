package patika.weterinersystem.service.abstracts;



import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.weterinersystem.dto.request.customer.CustomerSaveRequest;
import patika.weterinersystem.dto.request.customer.CustomerUpdateRequest;
import patika.weterinersystem.dto.response.customer.CustomerResponse;
import patika.weterinersystem.entities.Customer;

import java.util.List;

@Repository
public interface ICustomerService {
    Customer getOne(int id);
    List<CustomerResponse> getByName(String name);
    CustomerResponse save(CustomerSaveRequest customerSaveRequest);
    CustomerResponse get(int id);
    Page<CustomerResponse> cursor(int page, int pageSize);
    CustomerResponse update(CustomerUpdateRequest customerUpdateRequest);
    boolean delete(int id);
}
