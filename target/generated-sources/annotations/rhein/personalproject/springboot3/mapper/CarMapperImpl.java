package rhein.personalproject.springboot3.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import rhein.personalproject.springboot3.domain.Car;
import rhein.personalproject.springboot3.domain.Car.CarBuilder;
import rhein.personalproject.springboot3.requests.car.CarPostRequestBody;
import rhein.personalproject.springboot3.requests.car.CarPutRequestBody;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-24T18:46:09-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.8 (IBM Corporation)"
)
@Component
public class CarMapperImpl extends CarMapper {

    @Override
    public Car toCar(CarPostRequestBody carPostRequestBody) {
        if ( carPostRequestBody == null ) {
            return null;
        }

        CarBuilder car = Car.builder();

        car.name( carPostRequestBody.getName() );
        car.model( carPostRequestBody.getModel() );
        car.registerNumber( carPostRequestBody.getRegisterNumber() );
        car.colour( carPostRequestBody.getColour() );
        car.numberOfSeat( carPostRequestBody.getNumberOfSeat() );

        return car.build();
    }

    @Override
    public Car toCar(CarPutRequestBody carPutRequestBody) {
        if ( carPutRequestBody == null ) {
            return null;
        }

        CarBuilder car = Car.builder();

        car.name( carPutRequestBody.getName() );
        car.model( carPutRequestBody.getModel() );
        car.registerNumber( carPutRequestBody.getRegisterNumber() );
        car.colour( carPutRequestBody.getColour() );
        car.numberOfSeat( carPutRequestBody.getNumberOfSeat() );

        return car.build();
    }
}
