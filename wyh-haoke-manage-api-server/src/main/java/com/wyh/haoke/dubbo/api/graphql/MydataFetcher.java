package com.wyh.haoke.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;
import lombok.Data;


public interface MydataFetcher {

    /**
     * Graphql中的查询的名称
     * @return
     */
    String fileName();

    /**
     * 数据的查询
     * @param environment
     * @return
     */
    Object dataFotchor(DataFetchingEnvironment environment);
}
