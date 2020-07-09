package pl.com.krx.piapi.function;

import pl.com.krx.piapi.dto.DeviceLogDto;
import pl.com.krx.piapi.model.DeviceLog;

import java.util.function.Function;

public class DeviceLogToDeviceLogDto implements Function<DeviceLog, DeviceLogDto> {
    @Override
    public DeviceLogDto apply(DeviceLog deviceLog) {
        return new DeviceLogDto(deviceLog.getValue(), deviceLog.getSampledAt());

    }
}
