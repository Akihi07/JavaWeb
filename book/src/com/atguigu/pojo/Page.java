package com.atguigu.pojo;

import java.util.List;

/**
 * 对象包含的数据
 * 1 当前的页码
 * 2 一个分页包含的数据数量
 * 3 总共分页数
 * 4 总共数据数量
 * 5 当前页包含的数据列表
 * @param <T>
 */
public class Page <T>{

    //默认情况下一页显示的数量
    public final static Integer PAGE_SIZE = 4;

    //当前页码数
    private Integer pageNo;

    //当前页面大小
    private Integer pageSize = PAGE_SIZE;

    //总共页码数
    private Integer pageTotal;

    //所有记录条数
    private Integer totalItems;

    //当前页面包含的记录封装的 List
    private List<T> pageItems;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<T> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<T> pageItems) {
        this.pageItems = pageItems;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", totalItems=" + totalItems +
                ", pageItems=" + pageItems +
                '}';
    }
}
