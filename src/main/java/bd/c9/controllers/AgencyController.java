package bd.c9.controllers;

import bd.c9.models.Agency;
import bd.c9.models.BankAccount;
import bd.c9.repositories.AgencyRepository;
import bd.c9.repositories.BankAccountRepository;
import bd.c9.utils.ViewUtils;
import bd.c9.views.AgencyView;
import bd.c9.views.BankAccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AgencyController {
    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountView bankAccountView;

    @Autowired
    private AgencyView agencyView;

    @Autowired
    private ViewUtils viewUtils;

    public void showAgencies(){
        List<Agency> agencies = agencyRepository.findAll();

        agencyView.showAgencies(agencies);
    }

    public void showAgenciesByBank(){
        Long bankId = viewUtils.input("Informe o ID do banco: ", Long::parseLong);

        List<Agency> agencies = agencyRepository.filterByBankId(bankId);

        agencyView.showAgencies(agencies);
    }

    public void showAgencyBankAccounts(String agencyNumber){
        List<BankAccount> bankAccounts = bankAccountRepository.filterByAgencyNumber(agencyNumber);

        bankAccountView.showBankAccounts(bankAccounts);
    }
}
