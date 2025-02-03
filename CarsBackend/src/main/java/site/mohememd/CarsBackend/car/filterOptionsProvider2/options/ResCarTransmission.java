package site.mohememd.CarsBackend.car.filterOptionsProvider2.options;

public class ResCarTransmission extends CarOption {
    public int optionId;
    public String optionName;
    public ResCarTransmission(int optionId, String optionName) {
        super(optionId, optionName);
        this.optionId = optionId;
        this.optionName = optionName;
    }
}
