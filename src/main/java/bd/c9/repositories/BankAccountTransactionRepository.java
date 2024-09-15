package bd.c9.repositories;

import bd.c9.models.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
    @Query("""
        SELECT bat FROM BankAccountTransaction bat
        WHERE bat.bankAccount.accountNumber = :bankAccountNumber
        AND bat.transactionDate BETWEEN :startDate AND :endDate
    """)
    public List<BankAccountTransaction> filterByBankAccountByPeriodAndAccount(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("bankAccountNumber") String bankAccountNumber
    );
}
