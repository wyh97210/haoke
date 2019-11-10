package com.wyh.dobbo.ad.api;

import com.wyh.dobbo.ad.pojo.Ad;
import com.wyh.haoke.dubbo.vo.PageInfo;

public interface ApiAdService {
/**
* 分页查询广告数据
*
* @param type 广告类型
* @param page 页数
* @param pageSize 每页显示的数据条数
* @return
*/
PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize);
}