package com.wyh.haoke.dubbo.api.graphql;

import com.wyh.haoke.dubbo.api.service.MongoHouseService;
import com.wyh.haoke.dubbo.api.vo.map.MapHouseDataResult;
import com.wyh.haoke.dubbo.api.vo.map.MapHouseXY;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapHouseDataFetcher  implements MydataFetcher{

    @Autowired
    private MongoHouseService mongoHouseService;
    @Override
    public String fileName() {
        return "MapHouseData";
    }

    @Override
    public Object dataFotchor(DataFetchingEnvironment environment) {
        Float lng = ((Double)environment.getArgument("lng")).floatValue();
        Float lat = ((Double)environment.getArgument("lat")).floatValue();
        Integer zoom = environment.getArgument("zoom");
        System.out.println("lng->" + lng + ",lat->" + lat + ",zoom->" + zoom);
        return this.mongoHouseService.queryHouseData(lng,lat,zoom);
    }
}
