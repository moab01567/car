package site.mohememd.CarsBackend.car.filterOptionsProvider2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import site.mohememd.CarsBackend.car.filterOptionsProvider2.options.*;
import site.mohememd.CarsBackend.entity.carFuel.CarFuel;
import site.mohememd.CarsBackend.entity.carFuel.CarFuelRepository;
import site.mohememd.CarsBackend.entity.carStatus.CarStatus;
import site.mohememd.CarsBackend.entity.carStatus.CarStatusRepository;
import site.mohememd.CarsBackend.entity.carType.CarType;
import site.mohememd.CarsBackend.entity.carType.CarTypeRepository;
import site.mohememd.CarsBackend.entity.handleStatus.HandleStatus;
import site.mohememd.CarsBackend.entity.handleStatus.HandleStatusRepository;
import site.mohememd.CarsBackend.entity.transmission.Transmission;
import site.mohememd.CarsBackend.entity.transmission.TransmissionRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarFilterService {
    @Autowired
    CarTypeRepository carTypeRepo;

    @Autowired
    CarFuelRepository carFuelRepo;
    @Autowired
    CarStatusRepository carStatusRepo;
    @Autowired
    HandleStatusRepository handleStatusRepo;
    @Autowired
    TransmissionRepository transmissionRepo;




    public List<?> getFilterOptions(String filterType) {
        List<?> filterOptions;
        switch (filterType){
            case "carType" -> filterOptions = getCarType();

            case "carFuel" -> filterOptions = getCarFuel();

            case "carStatus" -> filterOptions =  getCarStatus();

            case "handleStatus" -> filterOptions =  getHandleStatus();

            case "transmission" -> filterOptions =  getTransmission();

            case "carSeats" -> filterOptions = getCarSeats();

            default -> filterOptions = new ArrayList<>();
        }

        return filterOptions;
    }

    private List<ResCarTransmission> getTransmission() {
        ArrayList<ResCarTransmission> resCarTransmissions = new ArrayList<>();
        List<Transmission> transmissions = transmissionRepo.findAll();
        transmissions.forEach((transmission)->
                resCarTransmissions.add(
                        new ResCarTransmission(
                                transmission.getTransmissionId(),transmission.getTransmissionType())));
        return resCarTransmissions;
    }

    private List<ResHandleStatus> getHandleStatus() {
        ArrayList<ResHandleStatus> resHandleStatuses = new ArrayList<>();
        List<HandleStatus> handleStatuses = handleStatusRepo.findAll();
        handleStatuses.forEach(handleStatus -> resHandleStatuses.add(
                new ResHandleStatus(
                        handleStatus.getHandleStatusId(),
                        handleStatus.getHandleName())));
        return resHandleStatuses;
    }

    private List<ResCarStatus> getCarStatus() {
        ArrayList<ResCarStatus> resCarStatuses = new ArrayList<>();
        List<CarStatus> carStatuses = carStatusRepo.findAll();
        carStatuses.forEach(carStatus -> resCarStatuses.add(new ResCarStatus(
                carStatus.getCarStatusId(),
                carStatus.getStatusType())));
        return resCarStatuses;

    }

    private List<ResCarType> getCarType() {
        ArrayList<ResCarType> resCarTypes = new ArrayList<>();
        List<CarType> carTypes = carTypeRepo.findAll();
        carTypes.forEach(carType -> resCarTypes.add(new ResCarType(
                carType.getCarTypeId(),
                carType.getCarModel())));
        return resCarTypes;

    }

    private List<ResCarFuel> getCarFuel() {
        ArrayList<ResCarFuel> resCarFuels = new ArrayList<>();
        List<CarFuel> carFuels = carFuelRepo.findAll();

        carFuels.forEach(carFuel -> resCarFuels.add(new ResCarFuel(
                carFuel.getCarFuelId(),
                carFuel.getFuelName())));
        return resCarFuels;
    }


    private ArrayList<CarSeat> getCarSeats() {
        ArrayList<CarSeat> carSeats = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            carSeats.add(new CarSeat(i,(i)+""));
        }
        return carSeats;
    }
}
