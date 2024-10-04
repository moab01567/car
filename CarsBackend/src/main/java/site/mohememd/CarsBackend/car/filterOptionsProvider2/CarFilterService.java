package site.mohememd.CarsBackend.car.filterOptionsProvider2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.car.filterOptionsProvider2.options.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarFilterService {
    @Autowired
    CarFilterRepository carFilterRepository;
    public List<?> getFilterOptions(String filterType) {
        List<?> filterOptions;
        switch (filterType){
            case "carType" -> filterOptions = carFilterRepository.selectAvailableOptions(CarFilterRepository.selectAllCarTypes,
                    (rw, num) ->  new CarType(rw.getInt(1), rw.getString(2)));

            case "carFuel" -> filterOptions =  carFilterRepository.selectAvailableOptions(CarFilterRepository.selectAllCarFuel,
                    (rw,num)->  new CarFuel(rw.getInt(1),rw.getString(2)));

            case "carStatus" -> filterOptions =  carFilterRepository.selectAvailableOptions(CarFilterRepository.selectAllCarStatus,
                    (rw,num)-> new CarStatus(rw.getInt(1),rw.getString(2)));

            case "handleStatus" -> filterOptions =  carFilterRepository.selectAvailableOptions(CarFilterRepository.selectAllHandleStatus,
                    (rw,num)-> new CarHandleStatus(rw.getInt(1),rw.getString(2)));
            case "transmission" -> filterOptions =  carFilterRepository.selectAvailableOptions(CarFilterRepository.selectAllTransmission,
                    (rw,num)-> new CarHandleStatus(rw.getInt(1),rw.getString(2)));
            case "carSeats" -> filterOptions = getCarSeats();
            default -> filterOptions = new ArrayList<>();
        }

        return filterOptions;
    }

    private ArrayList<CarSeat> getCarSeats() {
        ArrayList<CarSeat> carSeats = new ArrayList<>();
        for (int i = 0; i < 9 ; i++) {
            carSeats.add(new CarSeat(i,(i+1)+""));
        }
        return carSeats;
    }
}
