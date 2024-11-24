package vn.edu.iuh.fit.coffeehouse.ids;

import lombok.Data;
import vn.edu.iuh.fit.coffeehouse.models.Product;

import java.io.Serializable;

@Data
public class ProductSize_Id implements Serializable {
    private String name;
    private long product;
}
