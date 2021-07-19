package com.techwave.product.Controller;

import com.techwave.product.entity.Product;
import com.techwave.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/getproductsid/{Id}")
    public Product getProductById(@PathVariable("Id") int id)
    {
       return productService.getProductById(id);
    }
    @GetMapping("/getproductsname/{Name}")
    public Product getProductByName(@PathVariable("Name") String name)
    {
        return productService.getProductByName(name);
    }
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @PutMapping("/updateproduct/{Id}")
    public Product updateProduct(@PathVariable("Id") int id,@RequestBody Product product)
    {
        Product exitProduct = productService.getProductById(id);

        exitProduct.setName(product.getName());
        exitProduct.setBrand(product.getBrand());
        return productService.updateProduct(exitProduct);

    }

    @DeleteMapping("/deleteproduct/{Id}")
    public String deleteProduct(@PathVariable("Id") int id)
    {
        return productService.deleteProduct(id);
    }






}
