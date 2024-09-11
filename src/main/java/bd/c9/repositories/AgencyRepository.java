package bd.c9.repositories;

import bd.c9.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgencyRepository extends JpaRepository<Agency, String> {

    @Query("SELECT a FROM Agency a")
    public List<Agency> findAll();

    @Query("SELECT a FROM Agency a WHERE a.bank.id = :bankId")
    public List<Agency> filterByBankId(@Param("bankId") Long bankId);
}
