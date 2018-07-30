package com.bootcamp.finalProyect.controller;

import com.bootcamp.finalProyect.model.Cart;
import com.bootcamp.finalProyect.model.Product;
import com.bootcamp.finalProyect.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@Api(value = "Carts microservice", description = "This API has a CRUD for an user's cart")
@RequestMapping("")
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	HttpSession session;

	@PostMapping("products/{id}")
	@ApiOperation(value = "Add a Product to the users cart", notes = "If the user don't have an open cart, it will create a new one" )
	public void addProductToCart(@PathVariable("id") int productid) throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			int userid = (int) session.getAttribute("userid");
			cartService.addProductToCart(productid, userid);
		}
		else{
			throw  new  Exception("Non session created");
		}

	}

	@GetMapping(value = "carts/{id}", produces = "application/json")
	@ApiOperation(value = "Get the products from a cart", notes = "returns the product list of the selected cart" )
	public Set<Product> getProductsFromCart(@PathVariable("id") int cartid) throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			return cartService.listAllProducts(cartid);
		}
		else{
			throw  new  Exception("Non session created");
		}

	}

	@GetMapping(value = "carts", produces = "application/json")
	@ApiOperation(value = "Get the carts of an user", notes = "returns the cart list of the logged user" )
	public List<Cart> getAllCarts() throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			int userid = (int) session.getAttribute("userid");
			return cartService.getAllCarts(userid);
		}
		else{
			throw  new  Exception("Non session created");
		}

	}

	@PostMapping("carts/{id}")
	@ApiOperation(value = "Buy an open cart", notes = "Update the state of the selected cart, it's set it to 'true'" )
	public void buyCart(@PathVariable("id") int cartid) throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			cartService.buyCart(cartid);
		}
		else{
			throw  new  Exception("Non session created");
		}

	}

	@DeleteMapping("carts/{id}")
	@ApiOperation(value = "Cancel the selected cart", notes = "delete an open cart" )
	public void cancelCart(@PathVariable("id") int cartid) throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			cartService.cancelCart(cartid);
		}
		else{
			throw  new  Exception("Non session created");
		}

	}

	@PutMapping(value = "carts/{id}", params = "productid")
	@ApiOperation(value = "Delete a product from the cart", notes = "Deletes a product from the product list of the cart" )
	public void deleteProductFromCart(@PathVariable("id") int cartid,
			@RequestParam(value = "productid") int productid) throws Exception {
		if(Objects.nonNull(session.getAttribute("userid"))) {
			cartService.deleteProductFromCart(cartid, productid);
		}
		else{
			throw  new  Exception("Non session created");
		}
	}

}
