package com.wyh.haoke.dubbo.api;



import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.vo.PageInfo;

public interface ApiHouseResourcesService {
/**
*新增房源
* @param houseResources
*
* @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
*/
int saveHouseResources(HouseResources houseResources);
    /**
     * 分页查询房源列表
** @param page 当前页
* @param pageSize 页面大小
* @param queryCondition 查询条件
* @return
        */
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize,HouseResources queryCondition);

    /**
     * 根据id差查询房源
     * @param id
     * @return
     */
    HouseResources queryHouseResourcesById(Long id);

    /**
     * 修改房源
     *
     * @param houseResources
     * @return
     */
    boolean updateHouseResources(HouseResources houseResources);
}
