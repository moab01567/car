package site.mohememd.CarsBackend;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mohememd.CarsBackend.car.ownerHandler.CarOwnerService;
import site.mohememd.CarsBackend.entity.Owners;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarOwnersServiceTests {

    @Autowired
    CarOwnerService carOwnerService;

    @Test @Order(1)
    public void getOwnersByCarRegTest(){
        List<Owners> owners = carOwnerService.getOwnersByCarReg("BR35996");
        for (Owners owner : owners) {
            System.out.println(owner.getCar().getReg());
            System.out.println(owner.getPerson().getName());
        }
        assertEquals(1,owners.size());
    }
    @Test @Order(2)
    public void getOwnersByTlfTest(){
        List<Owners> owners = carOwnerService.getOwnersByTlf(0);

        for (Owners owner : owners) {
            System.out.println(owner.getCar().getReg());
            System.out.println(owner.getPerson().getName());
        }
        assertEquals(owners.size(),owners.size());
    }

}
