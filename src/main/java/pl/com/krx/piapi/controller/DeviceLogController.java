package pl.com.krx.piapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.com.krx.piapi.dto.DeviceLogDto;
import pl.com.krx.piapi.service.DeviceLogService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/device")
public class DeviceLogController {


    private DeviceLogService deviceLogService;

    @Autowired
    public DeviceLogController(DeviceLogService deviceLogService) {
        this.deviceLogService = deviceLogService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void saveDeviceLog(@PathVariable("id") UUID deviceId, @RequestBody @Valid DeviceLogDto deviceLogDto) {

        deviceLogService.add(deviceId, deviceLogDto);

    }

    @GetMapping("/{id}")
    public List<DeviceLogDto> findByDevice(@PathVariable("id") UUID deviceId, @RequestParam(required = true) Integer from, @RequestParam(required = true) Integer size) {
        return deviceLogService.findByDeviceId(deviceId, PageRequest.of(from, size));
    }

}
