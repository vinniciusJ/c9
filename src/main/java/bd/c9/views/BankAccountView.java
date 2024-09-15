package bd.c9.views;

import bd.c9.models.BankAccount;
import bd.c9.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankAccountView {
    @Autowired
    private ViewUtils viewUtils;

    public void showBankAccounts(List<BankAccount> bankAccounts){
        List<String> headers = List.of("N° da conta", "Tipo da conta", "Saldo", "Cliente", "Agência", "Banco");

        viewUtils.showTable(headers, bankAccounts, (bankAccount -> List.of(
                bankAccount.getAccountNumber(),
                bankAccount.getAccountType().getName(),
                bankAccount.getBalance().toString(),
                bankAccount.getClient().getName(),
                bankAccount.getAgencyAccount().getName(),
                bankAccount.getAgencyAccount().getBank().getName()
        )));
    }

    public void showBankAccount(BankAccount bankAccount){
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("N° da conta", bankAccount.getAccountNumber());
        table.addRule();
        table.addRow("Banco", bankAccount.getAgencyAccount().getBank().getName());
        table.addRule();
        table.addRow("Agência", bankAccount.getAgencyAccount().getName());
        table.addRule();
        table.addRow("Tipo da conta", bankAccount.getAccountType().getName());
        table.addRule();
        table.addRow("Data de abertura", viewUtils.formatDate(bankAccount.getOpeningDate()));
        table.addRule();
        table.addRow("Saldo", viewUtils.formatCurrency(bankAccount.getBalance()));
        table.addRule();

        System.out.println(table.render());
    }
}
