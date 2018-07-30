package com.bootcamp.finalProyect.service;

import com.bootcamp.finalProyect.model.Cart;
import com.bootcamp.finalProyect.model.Product;
import com.bootcamp.finalProyect.model.User;
import com.bootcamp.finalProyect.repository.CartRepository;
import com.bootcamp.finalProyect.repository.ProductRepository;
import com.bootcamp.finalProyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;


    public Cart createCart(User user){
        Cart cart = new Cart();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        cart.setDate(date);
        cart.setState(false);
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    public void addProductToCart(int productid, int userid) throws Exception{
        Product product = productRepository.getOne(productid);
        if (product.getStock() != 0){
            User user = userRepository.getOne(userid);
            Set<Cart> usercarts = user.getCarts();
            boolean band = false;
            Iterator iterator = usercarts.iterator();
            while (iterator.hasNext()){
                Cart usercart = (Cart) iterator.next();
                boolean state = usercart.isState();
                if (!state){
                    usercart.getProducts().add(product);
                    cartRepository.save(usercart);
                    band = true;
                }
            }
            if (!band){
                Cart cart = createCart(user);
                cart.getProducts().add(product);
                cartRepository.save(cart);
            }
        }
        else {
            throw new Exception("Can't add product to cart, there's no stock available");
        }
    }

    public Set<Product> listAllProducts(int cartid){
        Cart cart = cartRepository.getOne(cartid);
        Set <Product> productList = cart.getProducts();
        return productList;
    }

    public void buyCart(int cartid){
        Cart cart = cartRepository.getOne(cartid);
        Set <Product> productList = cart.getProducts();
        Iterator iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            product.setStock(product.getStock() - 1);
            productRepository.save(product);
        }
        cart.setState(true);
        cartRepository.save(cart);
    }

    public void cancelCart(int cartid){
        Cart cart = cartRepository.getOne(cartid);
        if (!cart.isState()) {
            cartRepository.delete(cart);
        }
    }

    public void deleteProductFromCart(int cartid, int productid){
        Cart cart = cartRepository.getOne(cartid);
        Product product = productRepository.getOne(productid);
        if (!cart.isState()){
            cart.getProducts().remove(product);
            cartRepository.save(cart);
        }
    }

    public List<Cart> getAllCarts(int userid){
        User user = userRepository.getOne(userid);
        return cartRepository.findAllByUser(user);
    }
}
