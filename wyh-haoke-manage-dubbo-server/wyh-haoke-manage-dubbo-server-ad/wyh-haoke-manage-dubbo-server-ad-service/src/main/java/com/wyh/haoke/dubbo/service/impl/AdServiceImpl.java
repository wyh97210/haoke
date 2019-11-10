package com.wyh.haoke.dubbo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyh.dobbo.ad.pojo.Ad;
import com.wyh.haoke.dubbo.service.AdService;
import com.wyh.haoke.dubbo.service.BaseServiceImpl;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl  extends BaseServiceImpl<Ad> implements AdService {
    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.orderByAsc("updated");

        queryWrapper.eq("type",ad.getType());
        IPage iPage = super.queryPageList(queryWrapper,page,pageSize);
        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(), page,pageSize, iPage.getRecords());
    }
}
