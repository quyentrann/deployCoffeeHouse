package vn.edu.iuh.fit.coffeehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.coffeehouse.ids.Favorite_Id;
import vn.edu.iuh.fit.coffeehouse.models.Favorite;
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Favorite_Id> {
    Favorite findByUserIdAndProductId(long userId, long productId);
}