package com.cookieIT.exampleApp.ExampleApp.common.criteria;

import org.springframework.util.Assert;

public class PageCriteria {

    protected final int page;
    protected final int pageSize;

    public PageCriteria(int page, int pageSize) {
        Assert.notNull(page, "page == null");
        Assert.notNull(pageSize, "pageSize == null");
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

}
