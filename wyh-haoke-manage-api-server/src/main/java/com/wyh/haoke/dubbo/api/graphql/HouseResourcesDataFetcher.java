package com.wyh.haoke.dubbo.api.graphql;

import com.wyh.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesDataFetcher implements MydataFetcher {
    @Autowired
    private HouseResourcesService houseResourcesService;
    @Override
    public String fileName() {
        return "HouseResources";
    }

    @Override
    public Object dataFotchor(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
        return this.houseResourcesService.queryHouseResourcesById(id);
    }
}

