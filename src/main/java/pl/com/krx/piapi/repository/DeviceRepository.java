package pl.com.krx.piapi.repository;

import org.springframework.data.repository.CrudRepository;
import pl.com.krx.piapi.model.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, UUID> {

    List<Device> findByAccount_Id(UUID id);
}
