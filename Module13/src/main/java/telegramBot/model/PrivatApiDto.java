package telegramBot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrivatApiDto {

    private String ccy;       // Currency code, e.g., "EUR"
    private String base_ccy;  // Base currency code, usually "UAH"
    private String buy;       // Buying rate as a String to preserve decimal precision
    private String sale;

}
