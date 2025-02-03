package site.mohememd.CarsBackend.car;

import java.util.Date;

public record Car(int carID, String reg, String vin, String color, int totalDoors,
                  int totalSeats, int axlesInUse, int totalEngines, float length,
                  float width, Date registeredFirst, Date registeredFirstNorway, Date nextEUControl, String note,
                  String transmission, String status, String carType, String fuel, int handleStatusId, String handleStatus,Date followUp ) {
}
