package bd.c9.controllers;

import bd.c9.models.BankAccount;
import bd.c9.models.BankAccountTransaction;
import bd.c9.models.Client;
import bd.c9.models.PaymentMethod;
import bd.c9.repositories.BankAccountRepository;
import bd.c9.repositories.BankAccountTransactionRepository;
import bd.c9.repositories.ClientRepository;
import bd.c9.utils.ViewUtils;
import bd.c9.views.BankAccountTransactionView;
import bd.c9.views.BankAccountView;
import bd.c9.views.ClientView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountTransactionRepository bankAccountTransactionRepository;

    @Autowired
    private ViewUtils viewUtils;

    @Autowired
    private BankAccountView bankAccountView;

    @Autowired
    private ClientView clientView;


    public void showClients(){
        List<Client> clients = clientRepository.findAll();

        clientView.showClients(clients);
    }

    public void showClientBankAccounts(){
        String documentNumber = viewUtils.input("Informe o n° do documento do usuário: ");

        List<BankAccount> bankAccounts = bankAccountRepository.filterByClient(documentNumber);

        bankAccountView.showBankAccounts(bankAccounts);
    }


    public void showClientStatementByPeriodAndBankAccount(){
        showClientBankAccounts();

        String bankAccountNumber = viewUtils.input("N° da conta bancaria: ");
        LocalDate startDate = viewUtils.inputDate("Data inicial: ");
        LocalDate endDate = viewUtils.inputDate("Data fim: ");

        BankAccount bankAccount = bankAccountRepository.findByBankAccountNumber(bankAccountNumber);

        List<BankAccountTransaction> transactions = bankAccountTransactionRepository.filterByBankAccountByPeriodAndAccount(startDate, endDate,bankAccountNumber);


        if(bankAccount == null){
            return;
        }

        clientView.showClientsTransactionsStatementsByBankAccount(bankAccount, transactions, startDate, endDate);
    }
}
