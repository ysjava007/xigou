package cn.itsource.xigou.service.impl;

import cn.itsource.basic.util.PageList;
import cn.itsource.xigou.domain.Brand;
import cn.itsource.xigou.mapper.BrandMapper;
import cn.itsource.xigou.query.BrandQuery;
import cn.itsource.xigou.service.IBrandService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {



    @Override
    public PageList<Brand> brandPageList(BrandQuery query) {
        //查询总数
        //查询当前页的数据
        Page<Brand> page = new Page<>(query.getPageNum(),query.getPageSize());
        IPage<Brand> ip = baseMapper.brandPageList(page,query);
        //封装到PageList返回
        return new PageList<>(ip.getTotal(),ip.getRecords());
    }
}
