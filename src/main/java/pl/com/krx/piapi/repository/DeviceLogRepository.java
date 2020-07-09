package pl.com.krx.piapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.com.krx.piapi.model.DeviceLog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DeviceLogRepository extends PagingAndSortingRepository<DeviceLog, UUID> {

    List<DeviceLog> findByDevice_IdOrderBySampledAtDesc(UUID deviceId, Pageable pageable);

    Optional<DeviceLog> findFirstByDevice_IdOrderBySampledAtDesc(UUID deviceId);

    Optional<DeviceLog> findFirstByOrderBySampledAtDesc();

    List<DeviceLog> findBySampledAtAfterAndDevice_IdOrderBySampledAtAsc(LocalDateTime afterDate, UUID deviceId);


}
