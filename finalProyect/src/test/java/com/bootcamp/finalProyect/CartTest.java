package com.bootcamp.finalProyect;

import com.bootcamp.finalProyect.model.Product;
import com.bootcamp.finalProyect.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CartTest {
    @Test

    @Before
    public void setUp() throws Exception {
        User user = Mockito.mock(User.class);
        Product product = Mockito.mock(Product.class);
    }
}
