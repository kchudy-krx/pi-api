package pl.com.krx.piapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Tables.DEVICE_TABLE_NAME)
public class Device {

    @Id
    @GeneratedValue
    @Column(name = Tables.DEVICE_COLUMN_PREFIX + "id")
    private UUID id;

    @Column(name = Tables.DEVICE_COLUMN_PREFIX + "device_name", nullable = false)
    private String deviceName;

    @Column(name = Tables.DEVICE_COLUMN_PREFIX + "measure_type", nullable = false)
    private String measureType;

    @JoinColumn(name = Tables.ACCOUNT_COLUMN_PREFIX + "id", nullable = false)
    @ManyToOne
    private Account account;

}
