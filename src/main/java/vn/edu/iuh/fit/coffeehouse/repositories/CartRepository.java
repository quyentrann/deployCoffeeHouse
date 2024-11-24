package vn.edu.iuh.fit.coffeehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.coffeehouse.ids.Cart_Id;
import vn.edu.iuh.fit.coffeehouse.models.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Cart_Id> {
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.product.id = :productId AND c.user.id = :userId")
    void deleteByProductAndUser(@Param("productId") Long productId, @Param("userId") Long userId);
}