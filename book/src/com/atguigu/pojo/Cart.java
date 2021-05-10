package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private HashMap<Integer,CartItem> map = new HashMap<Integer,CartItem>();

    /**
     * 往购物车增加内容
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        CartItem item = map.get(cartItem.getId());
        if(item == null){
            map.put(cartItem.getId(),cartItem);
        }
        else {
            item.setCount(item.getCount() + cartItem.getCount());
            item.updateTotalItemPrice();
        }
    }



    /**
     * 删除购物车中的内容
     * @param id
     */
    public void deleteItem(Integer id){
        map.remove(id);
    }

    /**
     * 清空购物车的内容
     */
    public void clearCart(){
        map.clear();
    }


    /**
     * 更改购物车内容的数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        CartItem cartItem = map.get(id);
        if(cartItem != null) {
            cartItem.setCount(count);
            cartItem.updateTotalItemPrice();
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
            totalPrice = entry.getValue().getTotalItemPrice().add(totalPrice);
        }
        return totalPrice;
    }

    public HashMap<Integer, CartItem> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                '}';
    }
}
