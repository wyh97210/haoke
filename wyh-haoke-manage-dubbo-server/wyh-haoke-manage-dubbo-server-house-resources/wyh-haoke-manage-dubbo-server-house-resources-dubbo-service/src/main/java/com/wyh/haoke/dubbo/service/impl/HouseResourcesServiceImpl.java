package com.wyh.haoke.dubbo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyh.haoke.dubbo.pojo.HouseResources;
import com.wyh.haoke.dubbo.service.BaseServiceImpl;
import com.wyh.haoke.dubbo.service.HouseResourcesService;
import com.wyh.haoke.dubbo.vo.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //这是一个Spring的服务
@Transactional //开启事务
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {
public int saveHouseResources(HouseResources houseResources) {
// 编写校验逻辑，如果教研不通过，返回-1
        if (StringUtils.isBlank(houseResources.getTitle())) {
        return -1;
        }
        // 其他校验以及逻辑省略 ……
        return super.save(houseResources);
        }

        @Override
        public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
                QueryWrapper queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByDesc("updated");

                IPage<HouseResources> iPage = super.queryPageList(queryWrapper, page, pageSize);

                return new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
        }

        @Override
        public HouseResources queryHouseResourcesById(Long id) {
                return super.queryById(id);
        }

        /**
         * 更新房源
         * @param houseResources
         * @return
         */
        @Override
        public boolean updateHouseResources(HouseResources houseResources) {
                return super.update(houseResources) == 1;
        }
}
