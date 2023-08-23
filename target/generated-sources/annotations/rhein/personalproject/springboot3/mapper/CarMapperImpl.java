package rhein.personalproject.springboot3.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-23T10:37:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (IBM Corporation)"
)
@Component
public class CarMapperImpl extends CarMapper {

    @Override
    public Car toCar(CarPostRequestBody carPostRequestBody) {
        if ( carPostRequestBody == null ) {
            return null;
        }

        Car car = new Car();

        return car;
    }

    @Override
    public Car toCar(CarPutRequestBody carPutRequestBody) {
        if ( carPutRequestBody == null ) {
            return null;
        }

        Car car = new Car();

        return car;
    }
}
