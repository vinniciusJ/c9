package bd.c9.controllers;

import bd.c9.models.Bank;
import bd.c9.utils.ViewUtils;
import bd.c9.views.AppView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private AppView appView;

    @Autowired
    private ViewUtils viewUtils;

    @Autowired
    private BankController bankController;

    @Autowired
    private AgencyController agencyController;

    @Autowired
    private ClientController clientController;


    public void startApp(){
        appView.showMenu();

        int option = viewUtils.input("Escolha uma das opções acima: ", Integer::parseInt);

        switch (option){
            case 0 -> System.exit(0);
            case 1 -> bankController.showAll();
            case 2 -> agencyController.showAgenciesByBank();
            case 3 -> clientController.showClients();
            case 4 -> clientController.showClientBankAccounts();
            case 5 -> clientController.showClientStatementByPeriodAndBankAccount();
            default -> startApp();
        }

        startApp();
    }
}
