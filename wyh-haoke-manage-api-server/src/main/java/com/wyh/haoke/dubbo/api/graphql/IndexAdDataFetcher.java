package com.wyh.haoke.dubbo.api.graphql;

import com.wyh.dobbo.ad.pojo.Ad;
import com.wyh.haoke.dubbo.api.service.AdService;
import com.wyh.haoke.dubbo.api.vo.ad.index.IndexAdResult;
import com.wyh.haoke.dubbo.api.vo.ad.index.IndexAdResultData;
import com.wyh.haoke.dubbo.vo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IndexAdDataFetcher implements MydataFetcher {
@Autowired
private AdService adService;


    @Override
    public String fileName() {
        return "IndexAdList";
    }

    @Override
    public Object dataFotchor(DataFetchingEnvironment environment) {

        PageInfo<Ad> pageInfo = this.adService.queryAdList(1, 1, 3);
        List<Ad> ads = pageInfo.getRecords();
        List<IndexAdResultData> list = new ArrayList<>();
        for (Ad ad : ads) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }
        return new IndexAdResult(list);
    }
}