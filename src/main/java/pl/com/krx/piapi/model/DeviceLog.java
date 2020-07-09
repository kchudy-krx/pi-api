package pl.com.krx.piapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Tables.DEVICELOG_TABLE_NAME)
public class DeviceLog {

    @Id
    @GeneratedValue
    @Column(name = Tables.DEVICELOG_COLUMN_PREFIX + "id")
    private UUID id;

    @Column(name = Tables.DEVICELOG_COLUMN_PREFIX + "value", nullable = false, updatable = false)
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = Tables.DEVICE_COLUMN_PREFIX + "id", nullable = false, updatable = false)
    private Device device;

    @Column(name = Tables.DEVICELOG_COLUMN_PREFIX + "sampled_at", nullable = false, updatable = false)
    private LocalDateTime sampledAt;


}
