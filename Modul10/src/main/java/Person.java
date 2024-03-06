import lombok.Builder;
import lombok.Getter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Getter
@AllArgsConstructor
@Builder
@Data


public class Person {
        private List<Address> address;
        private int age;
        private boolean married;
        private double height;


}
