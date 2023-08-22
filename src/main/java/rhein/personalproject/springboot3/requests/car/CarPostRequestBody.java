package rhein.personalproject.springboot3.requests.car;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarPostRequestBody {
    @NotEmpty(message = "The name of this car cannot be empty")
    private String name;
    @NotEmpty(message = "The model of this car cannot be empty")
    private String model;
    private long registerNumber;
    @NotEmpty(message = "The colour of this car cannot be empty")
    private String colour;
    private int numberOfSeat;
}
