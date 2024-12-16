package pe.edu.examen.backoffice_final.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.examen.backoffice_final.dto.CarDto;
import pe.edu.examen.backoffice_final.response.DeleteCarsResponse;
import pe.edu.examen.backoffice_final.response.FindCarByIdResponse;
import pe.edu.examen.backoffice_final.response.FindCarsResponse;
import pe.edu.examen.backoffice_final.response.UpdateCarsResponse;
import pe.edu.examen.backoffice_final.service.ManageService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") Integer id){


        try{
            if (id > 0 ){
                Optional<CarDto> optional = manageService.getCarsByid(id);
                if (optional.isPresent()){
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                }else {
                    return new FindCarsResponse("02", "Car not found", null);
                }

            }else{
                List<CarDto> cars = manageService.getAllCar();
                return new FindCarsResponse("01", "", cars);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new FindCarsResponse("99", "Service not found", null);
        }

    }

//NO TOCAR//////////////////////////
    @GetMapping("/detail")
    public FindCarByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") Integer id){


        try{
            if (id > 0 ){
                Optional<CarDto> optional = manageService.getCarsByid(Integer.parseInt(String.valueOf(id)));
                if (optional.isPresent()){
                    CarDto carDto = optional.get();
                    return new FindCarByIdResponse("01", "", Collections.singleton(carDto));
                }else {
                    return new FindCarByIdResponse("02", "Car not found", null);
                }

            }else{
                List<CarDto> cars = manageService.getAllCar();
                return new FindCarByIdResponse("01", "", cars);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Service not found", null);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/update")
    public UpdateCarsResponse updateCar(@RequestBody CarDto carDto){

        try{
                if (manageService.updateCar(carDto)){
                    return new UpdateCarsResponse("01", "");
                }else {
                    return new UpdateCarsResponse("02", "Car not found");
                }
        }catch (Exception e){
            e.printStackTrace();
            return new UpdateCarsResponse("99", "Service not found");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DeleteMapping("/delete/{id}")
    public DeleteCarsResponse deleteCar(@PathVariable int id) {
        try {
            if (manageService.deleteCarById(id)) {
                return new DeleteCarsResponse("01", "Car deleted successfully");
            } else {
                return new DeleteCarsResponse("02", "Car not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarsResponse("99", "Service error");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/create")
    public UpdateCarsResponse createCar(@RequestBody CarDto carDto) {
        try {
            if (manageService.addCar(carDto)) {
                return new UpdateCarsResponse("01", "Car added successfully");
            } else {
                return new UpdateCarsResponse("02", "Failed to add car");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarsResponse("99", "Service error");
        }
    }


}
