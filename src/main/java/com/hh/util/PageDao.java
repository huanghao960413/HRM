package com.hh.util;

public class PageDao {

    public static int getTotalPages(int totalRows,int pageSize) {
        return totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
    }

}
