package telegramBot;

import lombok.Data;
import telegramBot.model.PrivatApiDto;
import java.util.List;

@Data
public class Currency {
    private List<PrivatApiDto> currencyList;
    private String selectedCurrency;

    public Currency(List<PrivatApiDto> currencyList) {
        this.currencyList = currencyList;
    }
}
