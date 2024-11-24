package vn.edu.iuh.fit.coffeehouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.coffeehouse.ids.OrderDetail_Id;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(OrderDetail_Id.class)
public class OrderDetail {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Id
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = {"toppings", "carts", "sizes","toppings","deleted", "lastModifiedDate", "createdDate"})
    private Product product;

    private double price;

    private int quantity;

    private double discount;
}
