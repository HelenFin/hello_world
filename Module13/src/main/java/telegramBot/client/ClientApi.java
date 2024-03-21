package telegramBot.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import telegramBot.model.PrivatApiDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static telegramBot.BotConstants.PRIVATBANK_URL;

public class ClientApi {

    private HttpClient client = HttpClient.newHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public List<PrivatApiDto> getPrivatBankApi() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PRIVATBANK_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<List<PrivatApiDto>>() {

        });
    }
}


