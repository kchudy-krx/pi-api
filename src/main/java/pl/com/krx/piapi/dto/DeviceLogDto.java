package pl.com.krx.piapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceLogDto {

    @PositiveOrZero
    private Double value;

    @NotNull
    @Past
    private LocalDateTime sampledAt;
}
