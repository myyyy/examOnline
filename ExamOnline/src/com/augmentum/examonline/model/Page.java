package com.augmentum.examonline.model;

import com.augmentum.examonline.until.PropertiesUtil;

public class Page{
    private static final String KEY_PAGE_SIZE ="TOODO";
    private int pageSize;
    private int pageCount;
    private int totalRows;
    private int pageNow;
    private int offset;
    private int bottomPageNo;

    public int getPageCount() {
        if (totalRows < 1) {
            pageCount = 0;
        return pageCount;
        }
        pageCount = (totalRows - 1)/getPagesize() + 1;
        return pageCount;
    }
    public int getPageNow() {
        if (pageNow<1) {
        pageNow = 1;
        }
        return pageNow;
    }
    public int getOffset() {
        offset = (getPageNow() - 1)*getPagesize();
        return offset;
    }
    public int getPagesize() {
        if (pageSize == 0){
            String size = PropertiesUtil.getProperty("page.size");
            pageSize = Integer.getInteger(size);
        }
        return pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getBottomPageNo() {
        return bottomPageNo;
    }
    public void setBottomPageNo(int bottomPageNo) {
        this.bottomPageNo = bottomPageNo;
    }
    public void setPagesize(int pagesize) {
        this.pageSize = pagesize;
    }
    public static String getKeyPageSize() {
        return KEY_PAGE_SIZE;
    }
}
