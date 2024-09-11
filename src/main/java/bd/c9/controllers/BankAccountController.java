package bd.c9.controllers;

import bd.c9.models.BankAccount;
import bd.c9.repositories.BankAccountRepository;
import bd.c9.views.BankAccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountView bankAccountView;

    public void showBankAccounts(){
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();

        bankAccountView.showBankAccounts(bankAccounts);
    }
}
