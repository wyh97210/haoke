package com.wyh.haoke.dubbo.service;

import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.vo.PageInfo;

public interface HouseResourcesService {
/**
*
* @param houseResources
*
* @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
*/
int saveHouseResources(HouseResources houseResources);

    /**
     * 查询房源
     * @param page
     * @param pageSize
     * @param queryCondition
     * @return
     */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);

    /**
     * 根据id查询房源
     * @param id
     * @return
     */
    HouseResources queryHouseResourcesById(Long id);

    /**
     * 更新房源
     * @param houseResources
     * @return
     */
    boolean updateHouseResources(HouseResources houseResources);
}