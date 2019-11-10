package com.wyh.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.wyh.dobbo.ad.api.ApiAdService;
import com.wyh.dobbo.ad.pojo.Ad;
import com.wyh.haoke.dubbo.api.ApiHouseResourcesService;
import com.wyh.haoke.dubbo.api.vo.Pagination;
import com.wyh.haoke.dubbo.api.vo.TableResult;
import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.stereotype.Component;

@Service
@Component
public class AdService {

@Reference(version = "1.0.0")
private ApiAdService apiAdService;

    /**
     *
     * @
     * @return
     */
    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize){
         return this.apiAdService.queryAdList(type, page, pageSize);
    }

}