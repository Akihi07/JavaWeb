package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {
    HashMap<Integer,CartItem> map = new HashMap<Integer,CartItem>();

    /**
     * 往购物车增加内容
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        Integer id = cartItem.getId();
        CartItem item = map.get(id);
        if(item == null){
            map.put(id,cartItem);
        }
        else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
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
            cartItem.setTotalPrice(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getCount())));
        }
    }



}
