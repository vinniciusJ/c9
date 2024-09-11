package bd.c9.views;

import bd.c9.models.Agency;
import bd.c9.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgencyView {
    @Autowired
    private ViewUtils viewUtils;

    public void showAgencies(List<Agency> agencies){
        List<String> headers = List.of("N° da agência", "Nome", "Banco", "Endereço");

        viewUtils.showTable(headers, agencies, (agency -> List.of(
                agency.getAgencyNumber(),
                agency.getName(),
                agency.getBank().getName(),
                agency.getAddress().toString(agency.getAddressNumber(), agency.getAddressComplement())
        )));
    }
}
