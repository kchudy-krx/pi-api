package pl.com.krx.piapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.com.krx.piapi.model.DeviceLog;
import pl.com.krx.piapi.service.DeviceLogService;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class TemplateController {

    private final DeviceLogService deviceLogService;

    @Autowired
    public TemplateController(DeviceLogService deviceLogService) {
        this.deviceLogService = deviceLogService;
    }

    @GetMapping("/")
    public String index(Model model) {

        Double currentTemperature = deviceLogService.findByDeviceId(UUID.fromString("6699e603-6e66-4070-b8c0-d841e02f918f")).map(DeviceLog::getValue).orElse(0.0);
        Double currentHumidity = deviceLogService.findByDeviceId(UUID.fromString("b391f090-4fc6-46e2-97f7-49737d2d1e2c")).map(DeviceLog::getValue).orElse(0.0);
        Double currentLight = deviceLogService.findByDeviceId(UUID.fromString("746992ae-40c8-49fb-924a-c6685e3ca92b")).map(DeviceLog::getValue).orElse(0.0);
        LocalDateTime sampledAt = deviceLogService.findLatestMeasurementDate().orElse(LocalDateTime.now());
        model.addAttribute("temp", currentTemperature);
        model.addAttribute("hum", currentHumidity);
        model.addAttribute("light", currentLight);
        model.addAttribute("lightPercentage", currentLight / 10 + "%");
        model.addAttribute("sampledAt", sampledAt);
        model.addAttribute("tempHistory", deviceLogService.findbyLastTwoDays(UUID.fromString("6699e603-6e66-4070-b8c0-d841e02f918f")));
        model.addAttribute("humHistory", deviceLogService.findbyLastTwoDays(UUID.fromString("b391f090-4fc6-46e2-97f7-49737d2d1e2c")));
        model.addAttribute("lightHistory", deviceLogService.findbyLastTwoDays(UUID.fromString("746992ae-40c8-49fb-924a-c6685e3ca92b")));
        return "index";
    }
}
