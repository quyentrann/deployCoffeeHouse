package vn.edu.iuh.fit.coffeehouse.ids;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetail_Id implements Serializable {
    private long order;
    private long product;
}
