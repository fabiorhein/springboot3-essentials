package rhein.personalproject.springboot3.requests.car;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CarPutRequestBody {
    @NotEmpty(message = "The id of this car cannot be empty")
    private UUID id;
    @NotEmpty(message = "The name of this car cannot be empty")
    private String name;
    @NotEmpty(message = "The model of this car cannot be empty")
    private String model;
    @NegativeOrZero(message = "The register number of this car cannot be negative or zero")
    private long registerNumber;
    @NotEmpty(message = "The colour of this car cannot be empty")
    private String colour;
    @NegativeOrZero(message = "The number of seat of this car cannot be negative or zero")
    private int numberOfSeat;
}
