package bd.c9.views;

import bd.c9.models.Bank;
import bd.c9.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankView {
    @Autowired
    private ViewUtils viewUtils;

    public void showBanks(List<Bank> banks){
        List<String> headers = List.of("ID", "Nome");

        viewUtils.showTable(headers, banks, (bank -> List.of(bank.getId().toString(), bank.getName())));
    }
}
