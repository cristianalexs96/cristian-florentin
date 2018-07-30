package com.bootcamp.finalProyect.service;

import com.bootcamp.finalProyect.model.Product;
import com.bootcamp.finalProyect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product){
        product.setStock(0);
        productRepository.save(product);
    }

    public void addStock(int productid, int stock){
        Product product = productRepository.getOne(productid);
        product.setStock(stock);
        productRepository.save(product);
    }

    public void editProduct(int idproduct, Product productedit){
        Product product = productRepository.getOne(idproduct);
        if (Objects.nonNull(productedit.getPrice())){
            product.setPrice(productedit.getPrice());
        }
        if (Objects.nonNull(productedit.getName())){
            product.setName(productedit.getName());
        }
        if (Objects.nonNull(productedit.getDescription())){
            product.setDescription(productedit.getDescription());
        }
        if (Objects.nonNull(productedit.getCategory())){
            product.setCategory(productedit.getCategory());
        }
        productRepository.save(product);
    }

    public List<Product> findByCategory(String category){
        List<Product> productList = new ArrayList<>();
        productList = productRepository.findByCategory(category);
        return productList;
    }

    public List<Product> findByName(String name){
        List<Product> productList = new ArrayList<>();
        productList = productRepository.findByName(name);
        return productList;
    }

    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        productList = productRepository.findAll();
        return productList;
    }

}
