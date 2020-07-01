package pl.com.krx.piapi.function;

import pl.com.krx.piapi.dto.DeviceLogDto;
import pl.com.krx.piapi.model.DeviceLog;

import java.util.function.Function;

public class Functions {

    public static Function<DeviceLog, DeviceLogDto> deviceLogDeviceLogDto = new DeviceLogToDeviceLogDto();

}
