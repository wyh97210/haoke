package com.wyh.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.wyh.haoke.dubbo.api.ApiHouseResourcesService;
import com.wyh.haoke.dubbo.api.vo.Pagination;
import com.wyh.haoke.dubbo.api.vo.TableResult;
import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.stereotype.Component;

@Service
@Component
public class HouseResourcesService {
@Reference(version = "1.0.0")
private ApiHouseResourcesService apiHouseResourcesService;

    /**
     * 新增
     * @param houseResources
     * @return
     */
    public boolean save(HouseResources houseResources){
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
}
    public TableResult queryList(HouseResources houseResources, Integer currentPage,
                                 Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.
                queryHouseResourcesList(currentPage, pageSize, houseResources);

        System.out.println("房源信息"+pageInfo);
        return new TableResult(pageInfo.getRecords(),new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    public HouseResources queryHouseResourcesById(Long id) {
        return this.apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return this.apiHouseResourcesService.updateHouseResources(houseResources);
    }
}