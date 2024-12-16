package pe.edu.examen.backoffice_final.service;

import pe.edu.examen.backoffice_final.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCar() throws Exception;

    Optional<CarDto> getCarsByid(int id) throws Exception;

    Optional<CarDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

   boolean deleteCarById(int id) throws Exception;

   boolean addCar(CarDto carDto) throws Exception;

}
