package bd.c9.views;

import bd.c9.models.*;
import bd.c9.models.phone.Phone;
import bd.c9.utils.ViewUtils;
import de.vandermeer.asciitable.AsciiTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientView {
    @Autowired
    private ViewUtils viewUtils;

    @Autowired
    private BankAccountView bankAccountView;

    @Autowired
    private BankAccountTransactionView bankAccountTransactionView;

    public void showClients(List<Client> clients){
        List<String> headers = List.of("ID", "Nome", "N° documento", "Tipo do cliente", "Endereço");

        viewUtils.showTable(headers, clients, (client -> List.of(
                client.getId().toString(),
                client.getName(),
                client.getDocumentNumber(),
                client.getClientType().toString(),
                client.getAddress().toString(client.getAddressNumber(), client.getAddressComplement())
        )));
    }

    public void showClientsTransactionsStatementsByBankAccount(BankAccount bankAccount, List<BankAccountTransaction> transactions){
        Client client = bankAccount.getClient();

        showClient(client);


        bankAccountView.showBankAccount(bankAccount);

        bankAccountTransactionView.showBankAccountTransactions(transactions);
    }

    private void showClient(Client client){
        AsciiTable clientTable = new AsciiTable();

        clientTable.addRule();
        clientTable.addRow("ID do cliente", client.getId().toString());
        clientTable.addRule();
        clientTable.addRow("Nome do cliente", client.getName());
        clientTable.addRule();
        clientTable.addRow("N° do documento", client.getDocumentNumber());
        clientTable.addRule();
        clientTable.addRow("Tipo do cliente", client.getClientType());
        clientTable.addRule();
        clientTable.addRow("Endereço", client.getAddress().toString(client.getAddressNumber(), client.getAddressComplement()));
        clientTable.addRule();

        System.out.println(clientTable.render());

        showClientEmails(client.getEmails());
        showClientPhones(client.getPhones());
    }

    private void showClientEmails(List<Email> emails){
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("E-mails");

        for(Email email: emails){
            table.addRule();
            table.addRow(email.getEmail());
        }

        table.addRule();

        System.out.println(table.render());
    }

    private void showClientPhones(List<Phone> phones){
        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("Telefones");

        for(Phone phone: phones){
            table.addRule();
            table.addRow(phone.toString());
        }

        table.addRule();

        System.out.println(table.render());
    }
}
