package pe.edu.examen.backoffice_final.response;

import pe.edu.examen.backoffice_final.dto.CarDto;

public record FindCarsResponse(String code, String error, Iterable<CarDto> cars) {
}
