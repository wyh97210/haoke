package com.wyh.haoke.dubbo.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyh.dobbo.ad.api.ApiAdService;
import com.wyh.dobbo.ad.pojo.Ad;

import com.wyh.haoke.dubbo.service.AdService;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {
    @Autowired
    private AdService adService;
    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        Ad ad = new Ad();
        ad.setType(type);
        return this.adService.queryAdList(ad, page, pageSize);
    }
}
