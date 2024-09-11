package bd.c9.utils;

import de.vandermeer.asciitable.AsciiTable;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

@Component
public class ViewUtils {
    private final Console console = System.console();

    public String input(String label){
        System.out.print(label);

        return console.readLine();
    }

    public <T> T input(String label, Function<String, T> parser){
        String input = input(label);

        try{
            return parser.apply(input);
        }
        catch (NumberFormatException e){
            System.out.println("Formato inválido. Por favor, tente novamente.");

            return input(label, parser);
        }
    }

    public LocalDate inputDate(String label){
        return input(label, date -> LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public void showMenu(String... options){
        AsciiTable menu = new AsciiTable();

        menu.addRule();

        for(String option : options){
            menu.addRow(option);
            menu.addRule();
        }

        System.out.println(menu.render());
    }

    public <T> void showTable(List<String> headers, List<T> data, Function<T, List<String>> rowRenderer) {
        AsciiTable menu = new AsciiTable();

        menu.addRule();
        menu.addRow(headers.toArray());
        menu.addRule();

        for (T item : data) {
            List<String> row = (List<String>) rowRenderer.apply(item);

            menu.addRow(row.toArray());
            menu.addRule();
        }

        System.out.println(menu.render());
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public void showError(Exception exception){
        System.out.println(exception.getMessage());
    }

    public String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return formatter.format(date);
    }

    public String formatCurrency(Double currency){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        return currencyFormatter.format(currency);
    }
}