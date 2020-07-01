package pl.com.krx.piapi.repository;

import org.springframework.data.repository.CrudRepository;
import pl.com.krx.piapi.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {

    Optional<Account> findByEmailAndPassword(String email, String password);

}
