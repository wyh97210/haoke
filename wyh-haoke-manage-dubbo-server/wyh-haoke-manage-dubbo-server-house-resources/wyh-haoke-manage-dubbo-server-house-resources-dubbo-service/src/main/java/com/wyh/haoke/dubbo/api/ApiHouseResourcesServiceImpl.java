package com.wyh.haoke.dubbo.api;


import com.alibaba.dubbo.config.annotation.Service;
import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.service.HouseResourcesService;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;



@Service(version = "1.0.0") // 这是dubbo服务，对外进行暴露
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        return this.houseResourcesService.queryHouseResourcesList(page, pageSize,
                queryCondition);
    }

    /**
     * 根据id查询房源
     * @param id
     * @return
     */
    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return this.houseResourcesService.queryHouseResourcesById(id);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.updateHouseResources(houseResources);

    }
}
