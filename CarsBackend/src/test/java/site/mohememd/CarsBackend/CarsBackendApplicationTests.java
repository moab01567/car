package site.mohememd.CarsBackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import site.mohememd.CarsBackend.car.CarRestController;
import site.mohememd.CarsBackend.car.filterSelectionsHandler.CarSelections;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CarsBackendApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void selectedOptionsTest(){
		CarRestController carRestController= new CarRestController();
		ArrayList<Integer> carIds = new ArrayList<>();
		carIds.add(1);
		ArrayList<Integer> carIds2 = new ArrayList<>();

		ArrayList<String> date = new ArrayList<>();


	}
}
