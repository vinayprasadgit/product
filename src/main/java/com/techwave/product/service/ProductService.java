package com.techwave.product.service;


import com.techwave.product.entity.Product;
import com.techwave.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(int id)
    {
        return productRepository.findById(id).get();
    }

    public Product getProductByName(String name)
    {
       List<Product> products = productRepository.findAll();
       Product product=null;

       for(Product pro:products)
       {
           if(pro.getName().equalsIgnoreCase(name))
               product=pro;
       }
       return product;
    }
    public Product addProduct(Product product)
    {
        productRepository.save(product);
        return product;
    }
    public Product updateProduct(Product product)
    {
        productRepository.save(product);
        return product;
    }
    public String deleteProduct(int id)
    {
        productRepository.deleteById(id);
        return "Record is Deleted Successfully";
    }
}
