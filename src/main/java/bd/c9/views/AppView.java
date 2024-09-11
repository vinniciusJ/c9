package bd.c9.views;

import bd.c9.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppView {
    @Autowired
    private ViewUtils viewUtils;

    public void showMenu(){
        viewUtils.showMenu(
                "[0] - Sair",
                "[1] - Listar todos os bancos",
                "[2] - Listar agências de um banco",
                "[3] - Listar todos os clientes",
                "[4] - Listar contas bancarias de um cliente",
                "[5] - Visualizar extrato de um cliente"
        );
    }
}
