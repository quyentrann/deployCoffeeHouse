package vn.edu.iuh.fit.coffeehouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.*;
import vn.edu.iuh.fit.coffeehouse.ids.ProductSize_Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ProductSize_Id.class)
public class ProductSize {

    @Id
    @ManyToOne
    @JsonIgnore
    private Product product;

    @Id
    private String name;

    private double price;
}
