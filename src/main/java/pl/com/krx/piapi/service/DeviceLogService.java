package pl.com.krx.piapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.com.krx.piapi.dto.DeviceLogDto;
import pl.com.krx.piapi.model.DeviceLog;
import pl.com.krx.piapi.repository.DeviceLogRepository;
import pl.com.krx.piapi.repository.DeviceRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static pl.com.krx.piapi.function.Functions.deviceLogDeviceLogDto;

@Service
public class DeviceLogService {

    private final DeviceLogRepository deviceLogRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceLogService(DeviceLogRepository deviceLogRepository, DeviceRepository deviceRepository) {
        this.deviceLogRepository = deviceLogRepository;
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public Optional<DeviceLog> add(UUID deviceId, DeviceLogDto deviceLogDto) {
        return deviceRepository.findById(deviceId).map(device -> {
            DeviceLog deviceLog = new DeviceLog();
            deviceLog.setDevice(device);
            deviceLog.setSampledAt(deviceLogDto.getSampledAt());
            deviceLog.setValue(deviceLogDto.getValue());
            deviceLogRepository.save(deviceLog);
            return deviceLog;
        });

    }


    public List<DeviceLogDto> findByDeviceId(UUID deviceId, Pageable pageable) {

        return deviceLogRepository.findByDevice_IdOrderBySampledAtDesc(deviceId, pageable)
                .stream()
                .map(deviceLogDeviceLogDto)
                .collect(Collectors.toList());

    }

    public Optional<DeviceLog> findByDeviceId(UUID deviceId) {
        return deviceLogRepository.findFirstByDevice_IdOrderBySampledAtDesc(deviceId);
    }

    public Optional<LocalDateTime> findLatestMeasurementDate() {
        return deviceLogRepository.findFirstByOrderBySampledAtDesc().map(DeviceLog::getSampledAt);
    }

    public List<DeviceLogDto> findbyLastTwoDays(UUID deviceId) {
        return deviceLogRepository.findBySampledAtAfterAndDevice_IdOrderBySampledAtAsc(LocalDateTime.now().minusDays(2), deviceId)
                .stream()
                .map(deviceLogDeviceLogDto)
                .collect(Collectors.toList());
    }

}
