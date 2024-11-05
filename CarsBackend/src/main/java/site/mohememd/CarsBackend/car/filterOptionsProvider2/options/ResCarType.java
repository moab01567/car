package site.mohememd.CarsBackend.car.filterOptionsProvider2.options;

public class ResCarType extends CarOption {
    public int optionId;
    public String optionName;

    public ResCarType(int optionId, String optionName) {
        super(optionId, optionName);
        this.optionId = optionId;
        this.optionName=optionName;
    }
}
