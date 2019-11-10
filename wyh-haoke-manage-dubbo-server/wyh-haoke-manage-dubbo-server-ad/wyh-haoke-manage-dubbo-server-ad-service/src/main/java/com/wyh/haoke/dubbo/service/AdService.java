package com.wyh.haoke.dubbo.service;

import com.wyh.dobbo.ad.pojo.Ad;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.springframework.stereotype.Service;


public interface AdService {
PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}