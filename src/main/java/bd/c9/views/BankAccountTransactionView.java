package bd.c9.views;

import bd.c9.models.BankAccountTransaction;
import bd.c9.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankAccountTransactionView {
    @Autowired
    private ViewUtils viewUtils;

    public void showBankAccountTransactions(List<BankAccountTransaction> bankAccountTransactions) {
        List<String> headers = List.of("ID", "Data da transação", "Valor", "Tipo de transação", "Forma de pagamento",  "Conta bancaria", "Observação");

        viewUtils.showTable(headers, bankAccountTransactions, (bankAccountTransaction -> List.of(
                bankAccountTransaction.getId().toString(),
                viewUtils.formatDate(bankAccountTransaction.getTransactionDate()),
                viewUtils.formatCurrency(bankAccountTransaction.getAmount()),
                bankAccountTransaction.getTransactionType().getName(),
                bankAccountTransaction.getTransactionType().getPaymentMethod().toString(),
                bankAccountTransaction.getBankAccount().getAccountNumber(),
                bankAccountTransaction.getNote()
        )));
    }

}
