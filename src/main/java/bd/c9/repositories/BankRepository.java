package bd.c9.repositories;

import bd.c9.models.Agency;
import bd.c9.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query("SELECT b FROM Bank b")
    public List<Bank> findAll();

    @Query("""
        SELECT b FROM Bank b
        JOIN Agency a ON a.bank.id = b.id
        JOIN BankAccount ba ON ba.agencyAccount.agencyNumber = a.agencyNumber
        JOIN Client c ON c.id = ba.client.id
        WHERE c.id = :clientId
    """)
    public List<Bank> findByClientId(@Param("clientId") Long clientId);
}
