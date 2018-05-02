package edu.black.model;

import java.util.List;

public class PageCounter {
    private Integer pageNow;
    private Integer pageTotal;
    private Integer everyPageItemCount;
    private String url;

    public PageCounter() {
    }

    public PageCounter(List list,Integer pageNow, Integer everyPageItemCount) {
        this.pageNow = pageNow;
        this.everyPageItemCount = everyPageItemCount;
        this.pageTotal =(int)Math.ceil(list.size()*1.0/everyPageItemCount);
    }


    public PageCounter(Integer pageNow, Integer pageTotal, Integer everyPageItemCount) {
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
        this.everyPageItemCount = everyPageItemCount;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getEveryPageItemCount() {
        return everyPageItemCount;
    }

    public void setEveryPageItemCount(Integer everyPageItemCount) {
        this.everyPageItemCount = everyPageItemCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
