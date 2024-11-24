package vn.edu.iuh.fit.coffeehouse;

import net.datafaker.Faker;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.coffeehouse.ids.Cart_Id;
import vn.edu.iuh.fit.coffeehouse.models.*;
import vn.edu.iuh.fit.coffeehouse.repositories.CartRepository;
import vn.edu.iuh.fit.coffeehouse.repositories.OrderDetailRepository;
import vn.edu.iuh.fit.coffeehouse.repositories.OrderRepository;
import vn.edu.iuh.fit.coffeehouse.services.ProductService;
import vn.edu.iuh.fit.coffeehouse.services.UserService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CoffeeHouseApplicationTests {
    @Autowired
    private CartRepository cartRepository;
    @Test
    void test() {
         long userId = 1;
        long isp = 4;

        cartRepository.deleteByProductAndUser(userId,isp);
    }

}
