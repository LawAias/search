package com.example.aa.search.model;

import java.util.List;

/**
 * Created by aa on 2016/4/8.
 */
public class Search {

    /**
     * title : Hello
     * content : Hi
     * url : http://www.baidu.com
     */

    public List<ListEntity> list;


    public static class ListEntity {
        public String title;
        public String content;
        public String url;
    }
}
