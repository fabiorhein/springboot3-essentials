package rhein.personalproject.springboot3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car extends Entity {
    private String name;
    private String model;
    private long registerNumber;
    private String colour;
    private int numberOfSeat;
}
