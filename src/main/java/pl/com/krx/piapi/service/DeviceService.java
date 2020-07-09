package pl.com.krx.piapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.krx.piapi.model.Device;
import pl.com.krx.piapi.repository.DeviceRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {


    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> findByAccount(UUID accountId) {

        return deviceRepository.findByAccount_Id(accountId);
    }

}
