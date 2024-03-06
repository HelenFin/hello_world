import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import javax.lang.model.element.Name;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MainPerson {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Person person = Person.builder()
                .address((List.of(
                      new Address("holovna", "tchernivzi"),
                      new Address("holovna", "kyiv")
                )))
                .age(32)
                .married(true)
                .height(1.66)
                .build();


        String json = gson.toJson(person);

        System.out.println(json);
    }
}
