package vn.edu.iuh.fit.coffeehouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.coffeehouse.ids.Favorite_Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "favorite")
@IdClass(Favorite_Id.class)
public class Favorite {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = {"toppings", "carts", "deleted", "lastModifiedDate", "createdDate"})
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Favorite{" +
                "product=" + product +
                '}';
    }
}
