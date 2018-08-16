package com.cookieIT.exampleApp.ExampleApp.rest.response;

import java.util.List;

public class PagedResponse<T> {

    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private List<T> data;

    public PagedResponse(List<T> data, int page, int pageSize, long totalElements, int totalPages) {
        super();
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}

