package site.mohememd.CarsBackend.car.filterSelectionsHandler;

import java.util.ArrayList;
import java.util.List;

public class CarSelections {

    private List<Integer> carTypeIds;
    private List<Integer> transmissionIds;
    private List<Integer> carFuelIds;
    private List<Integer> carStatusIds;
    private List<Integer> carHandleStatusIds;
    private List<Integer> carSeatsIds;
    private String carFrom;
    private String carTo;
    private String EUFrom;
    private String EUTo;


    public List<Integer> getCarTypeIds() {
        return carTypeIds;
    }


    public List<Integer> getTransmissionIds() {
        return transmissionIds;
    }



    public List<Integer> getCarFuelIds() {
        return carFuelIds;
    }


    public List<Integer> getCarStatusIds() {
        return carStatusIds;
    }



    public List<Integer> getCarHandleStatusIds() {
        return carHandleStatusIds;
    }


    public List<Integer> getCarSeatsIds() {
        return carSeatsIds;
    }



    public String getCarFrom() {
        return carFrom;
    }


    public String getCarTo() {
        return carTo;
    }



    public String getEUFrom() {
        return EUFrom;
    }

    public void setEUFrom(String EUFrom) {
        this.EUFrom = EUFrom;
    }

    public String getEUTo() {
        return EUTo;
    }



    public CarSelections(List<Integer> carTypeIds, List<Integer> transmissionIds, List<Integer> carFuelIds, List<Integer> carStatusIds, List<Integer> carHandleStatusIds, List<Integer> carSeatsIds, String carFrom, String carTo, String EUFrom, String EUTo) {
        this.carTypeIds = carTypeIds;
        this.transmissionIds = transmissionIds;
        this.carFuelIds = carFuelIds;
        this.carStatusIds = carStatusIds;
        this.carHandleStatusIds = carHandleStatusIds;
        this.carSeatsIds = carSeatsIds;
        this.carFrom = carFrom;
        this.carTo = carTo;
        this.EUFrom = EUFrom;
        this.EUTo = EUTo;
    }

    public List<Object> getConcatenateLists(){
        List<Object> concatenateList = new ArrayList<>(carTypeIds);
        concatenateList.addAll(transmissionIds);
        concatenateList.addAll(carFuelIds);
        concatenateList.addAll(carStatusIds);
        concatenateList.addAll(carHandleStatusIds);
        concatenateList.addAll(carSeatsIds);
        if (!carFrom.isEmpty()) concatenateList.add(carFrom);
        if (!carTo.isEmpty()) concatenateList.add(carTo);
        if (!EUFrom.isEmpty()) concatenateList.add(EUFrom);
        if (!EUTo.isEmpty()) concatenateList.add(EUTo);

        return concatenateList;
    }

    @Override
    public String toString() {
        return "CarSelections{" +
                "carTypeIds=" + carTypeIds +
                ", transmissionIds=" + transmissionIds +
                ", carFuelIds=" + carFuelIds +
                ", carStatusIds=" + carStatusIds +
                ", carHandleStatusIds=" + carHandleStatusIds +
                ", carSeatsIds=" + carSeatsIds +
                ", carFrom='" + carFrom + '\'' +
                ", carTo='" + carTo + '\'' +
                ", EUFrom='" + EUFrom + '\'' +
                ", EUTo='" + EUTo + '\'' +
                '}';
    }
}
