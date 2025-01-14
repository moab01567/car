package site.mohememd.CarsBackend.exceptions;

public class FilterNotFound extends RuntimeException {
    public FilterNotFound(String filterName) {
        super("filter with code " + filterName + " not found");
    }
}
