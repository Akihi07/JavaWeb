package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clearCart() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        cart.clearCart();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }

    @Test
    public void getTotalCount() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        System.out.println(cart.getTotalCount());
    }

    @Test
    public void getTotalPrice() {
        cart.addItem(new CartItem(1,"Java核心技术",20, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(1,"Java核心技术",10, BigDecimal.valueOf(20.0)));
        cart.addItem(new CartItem(2,"JVM虚拟机规范",20, BigDecimal.valueOf(30.0)));
        System.out.println(cart.getTotalPrice());
    }
}