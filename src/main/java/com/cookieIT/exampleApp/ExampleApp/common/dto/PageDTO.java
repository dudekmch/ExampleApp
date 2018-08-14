package com.cookieIT.exampleApp.ExampleApp.common.dto;

import java.util.List;

public class PageDTO<T> {

    private List<T> data;
    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public PageDTO(List<T> data) {
        this(data, 0, data.size(), data.size(), 1);
    }

    public PageDTO(List<T> data, int pageNumber, int size, long totalElements, int totalPages) {
        this.data = data;
        this.page = pageNumber;
        this.pageSize = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;

    }

    public List<T> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

}
