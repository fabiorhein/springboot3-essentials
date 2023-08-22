package rhein.personalproject.springboot3.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Car extends BaseEntity {
    @NotEmpty(message = "The name of this car cannot be empty")
    private String name;
    @NotEmpty(message = "The model of this car cannot be empty")
    private String model;
    private long registerNumber;
    @NotEmpty(message = "The colour of this car cannot be empty")
    private String colour;
    private int numberOfSeat;
}
