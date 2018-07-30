package com.bootcamp.finalProyect.controller;

import com.bootcamp.finalProyect.model.Product;
import com.bootcamp.finalProyect.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Api(value = "Products microservice", description = "This API has a CRUD for the Products")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    HttpSession session;

    @PostMapping("")
    @ApiOperation(value = "Add a Product", notes = "Add a product to the DB" )
    public void addProduct( @Valid @RequestBody Product product) throws Exception {
        if(Objects.nonNull(session.getAttribute("userid"))) {
            productService.createProduct(product);
        }
        else{
            throw  new  Exception("No session created");
        }
    }

    @PutMapping(value = "/{id}", params = "stock")
    @ApiOperation(value = "Add a stock value to a Product", notes = "Adds stock to a selected value" )
    public void addStock(@PathVariable("id") int productid, @RequestParam(value = "stock") int stock) throws Exception {
        if(Objects.nonNull(session.getAttribute("userid"))) {
            productService.addStock(productid, stock);
        }
        else{
            throw  new  Exception("No session created");
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edit a product", notes = "Edit a selected product" )
    public void editProduct(@PathVariable("id") int productid, @Valid @RequestBody Product product) throws Exception {
        if(Objects.nonNull(session.getAttribute("userid"))) {
            productService.editProduct(productid, product);
        }
        else{
            throw  new  Exception("No session created");
        }
    }

    @GetMapping(value = "", params = "name")
    @ApiOperation(value = "Find products by Name", notes = "Returns a list with the founded products" )
    public List<Product> findByName(@RequestParam(value = "name") String name) throws Exception{
        if(Objects.nonNull(session.getAttribute("userid"))) {
            try {
                return productService.findByName(name);
            }
            catch (Exception e){
                throw new Exception("Error in services");
            }
        }
        else{
            throw  new  Exception("No session created");
        }
    }

    @GetMapping(value = "", params = "category")
    @ApiOperation(value = "Find products by Category", notes = "Returns a list with the founded products" )
    public List<Product> findByCategory(@RequestParam(value = "category") String category) throws Exception{
        if(Objects.nonNull(session.getAttribute("userid"))) {
            try {
                return productService.findByCategory(category);
            }
            catch (Exception e){
                throw new Exception("Error in services");
            }
        }
        else{
            throw  new  Exception("No session created");
        }
    }

    @GetMapping("")
    @ApiOperation(value = "List all products", notes = "Returns a list with all the products" )
    public List<Product> getAll() throws Exception{
        if(Objects.nonNull(session.getAttribute("userid"))) {
            try {
                return productService.getAllProducts();
            }
            catch (Exception e){
                throw new Exception("Error in services");
            }
        }
        else{
            throw  new  Exception("No session created");
        }
    }

}
