package site.mohememd.CarsBackend.car.filterOptionsProvider2.options;

public class CarTransmission extends CarOption {
    public int optionId;
    public String optionName;
    public CarTransmission(int optionId, String optionName) {
        super(optionId, optionName);
        this.optionId = optionId;
        this.optionName = optionName;
    }
}
