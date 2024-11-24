package vn.edu.iuh.fit.coffeehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.coffeehouse.repositories.ProductRepository;
import vn.edu.iuh.fit.coffeehouse.models.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product getProductByID(long idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }

    @Transactional
    public Product update(long id , Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Boolean delete(long idProduct) {
        try {
            productRepository.deleteById(idProduct);
            return true;
        } catch (Exception exception) {
        }
        return false;
    }
}
