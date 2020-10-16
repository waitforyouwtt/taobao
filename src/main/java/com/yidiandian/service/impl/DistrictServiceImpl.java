package com.yidiandian.service.impl;

import com.yidiandian.constants.DistrictConstants;
import com.yidiandian.entity.District;
import com.yidiandian.dao.DistrictDao;
import com.yidiandian.service.DistrictService;
import com.yidiandian.view.DistrictView;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 中国行政区划代码表
数据时间：2019年11月
数据来源：http://www.mca.gov.cn/article/sj/xzqh(District)表服务实现类
 *
 * @author makejava
 * @since 2020-10-16 18:36:33
 */
@Service("districtService")
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictDao districtDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public District queryById(Object id) {
        return this.districtDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<District> queryAllByLimit(int offset, int limit) {
        return this.districtDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    @Override
    public District insert(District district) {
        this.districtDao.insert(district);
        return district;
    }

    /**
     * 修改数据
     *
     * @param district 实例对象
     * @return 实例对象
     */
    @Override
    public District update(District district) {
        this.districtDao.update(district);
        return this.queryById(district.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.districtDao.deleteById(id) > 0;
    }

    @Override
    public List<DistrictView> findBbsAreaByUPid(Integer upid) {
        List<DistrictView> bbsAreaViewList = new ArrayList<>();
        District vo = new District();
        vo.setUpid(upid);
        if (StringUtils.isEmpty( upid ) || upid == 0) {
            upid = 0;
            vo.setUpid(upid);
            bbsAreaViewList = districtDao.findBbsAreaByUPid(vo);

           // Collections.sort(bbsAreaViewList, new BeanComparator<DistrictView>("areaId", new FixedOrderComparator( DistrictConstants.sortList() )));
            return bbsAreaViewList;
        }
        return districtDao.findBbsAreaByUPid( vo);
    }
}