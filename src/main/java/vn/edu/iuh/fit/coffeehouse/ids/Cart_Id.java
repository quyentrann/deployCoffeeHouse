package vn.edu.iuh.fit.coffeehouse.ids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart_Id implements Serializable {
    private Long product;
    private Long user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart_Id that = (Cart_Id) o;
        return Objects.equals(product, that.product) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, user);
    }
}
