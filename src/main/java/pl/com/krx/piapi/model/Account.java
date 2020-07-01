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
@Table(name = Account.ACCOUNT_TABLE_NAME)
public class Account {


    protected static final String ACCOUNT_TABLE_NAME = "account";
    protected static final String ACCOUNT_COLUMN_PREFIX = "acc_";

    @Id
    @GeneratedValue
    @Column(name = Tables.ACCOUNT_COLUMN_PREFIX + "id")
    private UUID id;

    @Column(name = Tables.ACCOUNT_COLUMN_PREFIX + "email", unique = true, updatable = false, nullable = false)
    private String email;

    @Column(name = Tables.ACCOUNT_COLUMN_PREFIX + "password", nullable = false)
    private String password;

    @Column(name = Tables.ACCOUNT_COLUMN_PREFIX + "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
