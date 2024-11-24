package vn.edu.iuh.fit.coffeehouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.coffeehouse.ids.Cart_Id;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart")
@IdClass(Cart_Id.class)
public class Cart {

    @Id
    @ManyToOne()
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = {"toppings", "carts", "deleted", "lastModifiedDate", "createdDate"})
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private int quantity;

    @Override
    public String toString() {
        return "Cart{" +
                "product=" + product +
//                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
