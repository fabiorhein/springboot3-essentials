package rhein.personalproject.springboot3.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {
    private String name;
    private String model;
    private long registerNumber;
    private String colour;
    private int numberOfSeat;
}
