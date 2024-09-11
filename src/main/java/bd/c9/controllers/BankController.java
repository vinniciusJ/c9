package bd.c9.controllers;

import bd.c9.models.Agency;
import bd.c9.models.Bank;
import bd.c9.repositories.AgencyRepository;
import bd.c9.repositories.BankRepository;
import bd.c9.views.AgencyView;
import bd.c9.views.BankView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankController {
    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private AgencyView agencyView;

    @Autowired
    private BankView bankView;

    public void showAll(){
        List<Bank> banks = bankRepository.findAll();

        bankView.showBanks(banks);
    }

    public void showBankAgencies(Long bankId){
        List<Agency> agencies = agencyRepository.filterByBankId(bankId);

        agencyView.showAgencies(agencies);
    }

}
