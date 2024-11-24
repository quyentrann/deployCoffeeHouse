package vn.edu.iuh.fit.coffeehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.coffeehouse.models.Cart;
import vn.edu.iuh.fit.coffeehouse.models.Favorite;
import vn.edu.iuh.fit.coffeehouse.models.Product;
import vn.edu.iuh.fit.coffeehouse.models.User;
import vn.edu.iuh.fit.coffeehouse.repositories.CartRepository;
import vn.edu.iuh.fit.coffeehouse.repositories.FavoriteRepository;
import vn.edu.iuh.fit.coffeehouse.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserByID(id);
    }
    @PostMapping
    public User update(User user) {
        return userService.create(user);
    }
    @GetMapping("getUserByPhone")
    public User getUserByPhone(@RequestParam String phone) {
        return userService.getUserByPhone(phone);
    }

    @PutMapping("forgot/{id}")
    public User updatePassword(@PathVariable long id, @RequestBody String newPassword) {
        System.out.println(newPassword);
        User user = userService.getUserByID(id);
        if (user == null) {
            throw new RuntimeException("User not found with id " + id);
        }
        user.setPassword(newPassword);
        return userService.update(id, user);
    }
    @PostMapping("signup")
    public User signUp(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable long id) {
        return userService.delete(id);
    }

    @GetMapping("/login")
    public User login(@RequestParam String phone , @RequestParam String password) {
        System.out.println(userService.getUserByPhoneAndPassword(phone,password));
        return userService.getUserByPhoneAndPassword(phone,password);
    }

    @GetMapping("/fullName")
    public User getUserByFullName(@RequestParam String fullName){
        return userService.getUserByFullName(fullName);
    }

    @GetMapping("/addFavorite")
    public User addFavorite(@RequestParam long userId, @RequestParam long productId){
        User newUser = User.builder().id(userId).build();
        Product newProduct = Product.builder().id(productId).build();
        Favorite favorite = Favorite.builder().user(newUser).product(newProduct).build();
        favoriteRepository.save(favorite);
        return userService.getUserByID(userId);
    }

    @DeleteMapping("deleteFavorite")
    public User deleteFavorite(@RequestParam long userId, @RequestParam long productId){
        Favorite favorite = favoriteRepository.findByUserIdAndProductId(userId, productId);
        if(favorite != null){
            favoriteRepository.delete(favorite);
        }
        return userService.getUserByID((userId));
    }

    @GetMapping("addCart")
    @Transactional
    public User addCart(@RequestParam long userId, @RequestParam long productId, @RequestParam int quantity){
        User user = userService.getUserByID((userId));
        Cart cart = Cart.builder()
                .user(user)
                .quantity(quantity)
                .product(Product.builder().id(productId).build())
                .build();
        user.getCarts().add(cart);
        return userService.update(userId,user);
    }
}
