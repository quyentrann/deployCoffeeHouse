package vn.edu.iuh.fit.coffeehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.coffeehouse.ids.OrderDetail_Id;
import vn.edu.iuh.fit.coffeehouse.models.OrderDetail;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail_Id> {
}