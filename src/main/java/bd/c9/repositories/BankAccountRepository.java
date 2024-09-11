package bd.c9.repositories;

import bd.c9.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @Query("SELECT ba FROM BankAccount ba")
    public List<BankAccount> findAll();

    @Query("SELECT ba FROM BankAccount ba WHERE ba.agencyAccount.agencyNumber = :agencyNumber")
    public List<BankAccount> filterByAgencyNumber(@Param("agencyNumber") String agencyNumber);

    @Query("""
        SELECT ba FROM BankAccount ba WHERE ba.client.id = (
            SELECT c.id FROM Client c WHERE c.documentNumber = :documentNumber
        )
    """)
    public List<BankAccount> filterByClient(@Param("documentNumber") String documentNumber);

    @Query("SELECT ba FROM BankAccount ba WHERE ba.accountNumber = :bankAccountNumber")
    public BankAccount findByBankAccountNumber(@Param("bankAccountNumber") String bankAccountNumber);
}
