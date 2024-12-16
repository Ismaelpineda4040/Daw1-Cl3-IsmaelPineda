package pe.edu.examen.backoffice_final.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.examen.backoffice_final.dto.CarDto;
import pe.edu.examen.backoffice_final.entity.Car;
import pe.edu.examen.backoffice_final.repository.CarRepository;
import pe.edu.examen.backoffice_final.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCar() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable =  carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCarId(), car.getMake(), car.getModel(), car.getColor());
            cars.add(carDto);
        });
        return cars;
    }

    @Override
    public Optional<CarDto> getCarsByid(int id) throws Exception {
        return Optional.empty();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Optional<CarDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);

        return optional.map(car -> new CarDto(car.getCarId(), car.getMake(), car.getModel(), car.getColor()));

    }

   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());

        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setColor(carDto.color());

            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);

        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean addCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        if(optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setColor(carDto.color());
            carRepository.save(car);
                    return true;
        }

    }
}
