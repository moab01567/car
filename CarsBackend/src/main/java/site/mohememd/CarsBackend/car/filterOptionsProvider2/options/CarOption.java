package site.mohememd.CarsBackend.car.filterOptionsProvider2.options;

public abstract class CarOption {

    public int  optionId;
    public String optionName;

    public CarOption(int optionId, String optionName) {
        this.optionId = optionId;
        this.optionName = optionName;
    }
}
