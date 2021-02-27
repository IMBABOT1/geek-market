package com.geekbrains.geek.market.services;

import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.repositories.ProductRepository;
import com.geekbrains.geek.market.repositories.specifications.ProductSpecifications;
import com.geekbrains.geek.market.utils.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }


    public Page<Product> edit(Long id, String title, Integer price, int page, int size){
        Specification<Product> spec = Specification.where(null);
        if (title != null && !title.isBlank()){
           spec = spec.and(ProductSpecifications.titleEquals(title));
        }
        if (id != null){
            spec = spec.and(ProductSpecifications.idEquals(id));
        }
        if (price != null){
            spec = spec.and(ProductSpecifications.priceEquals(price));
       }


//        Product product = new Product();
//        product.setId(id);
//        product.setTitle(title);
//        product.setPrice(price);
        return productRepository.findAll(spec, PageRequest.of(page, size));
   }
}
