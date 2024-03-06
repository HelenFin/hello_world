import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data

public class Address {

    private String street;
    private String city;
}