package vn.edu.iuh.fit.coffeehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.coffeehouse.ids.Cart_Id;
import vn.edu.iuh.fit.coffeehouse.models.Order;
import vn.edu.iuh.fit.coffeehouse.models.OrderDetail;
import vn.edu.iuh.fit.coffeehouse.models.Product;
import vn.edu.iuh.fit.coffeehouse.models.User;
import vn.edu.iuh.fit.coffeehouse.repositories.CartRepository;
import vn.edu.iuh.fit.coffeehouse.repositories.OrderRepository;
import vn.edu.iuh.fit.coffeehouse.repositories.UserRepository;
import vn.edu.iuh.fit.coffeehouse.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public Product update(Product product){
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable long id, @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable long id){
        return productService.delete(id);
    }

    @PostMapping("order/{userId}")
    @Transactional
    public User order(@PathVariable("userId") long userId, @RequestBody List<OrderDetail> orderDetails) {

        double totalPrice = 0;
        List<OrderDetail> details = new ArrayList<>();
        User user = User.builder().id(userId).build();
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        Order orderResult = orderRepository.save(order);
        for (OrderDetail orderDetail: orderDetails) {
            totalPrice += orderDetail.getPrice();
            details.add(OrderDetail.builder()
                            .order(orderResult)
                            .product(Product.builder().id(orderDetail.getProduct().getId()).build())
                            .quantity(orderDetail.getQuantity())
                            .price(orderDetail.getPrice())
                            .discount(0)
                    .build());
        }
        orderResult.setTotalPrice(totalPrice);
        orderResult.setOrderDetails(details);
        Order savedOrder = orderRepository.save(orderResult);

        if (savedOrder != null) {
            for (OrderDetail orderDetail : orderDetails) {
                cartRepository.deleteByProductAndUser(orderDetail.getProduct().getId(), userId);
            }
        }
        User userUpdate = userRepository.findById(userId).get();
        return  userUpdate;
    }

    @DeleteMapping("deleteCart/{userId}")
    @Transactional
    public User deleteCart(@PathVariable("userId") long userId, @RequestBody List<Long> productIds) {
        for (Long productId : productIds) {
            System.out.println(productId);
            cartRepository.deleteByProductAndUser(productId, userId);
        }
        User userUpdate = userRepository.findById(userId).get();
        return  userUpdate;
    }

}
