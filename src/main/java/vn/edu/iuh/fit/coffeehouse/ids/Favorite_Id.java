package vn.edu.iuh.fit.coffeehouse.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite_Id implements Serializable {
private  Long product;
private  Long user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favorite_Id that)) return false;
        return Objects.equals(product, that.product) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, user);
    }
}
