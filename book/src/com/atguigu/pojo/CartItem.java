package com.atguigu.pojo;

import java.math.BigDecimal;

public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalItemPrice;

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalItemPrice = price.multiply(BigDecimal.valueOf(count));
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalItemPrice() {
        updateTotalItemPrice();
        return totalItemPrice;
    }

    public void updateTotalItemPrice() {
        this.totalItemPrice = this.price.multiply(BigDecimal.valueOf(this.count));
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalItemPrice=" + totalItemPrice +
                '}';
    }
}
