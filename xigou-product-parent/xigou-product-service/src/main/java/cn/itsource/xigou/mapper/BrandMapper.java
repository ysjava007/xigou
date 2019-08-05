package cn.itsource.xigou.mapper;

import cn.itsource.basic.util.PageList;
import cn.itsource.xigou.domain.Brand;
import cn.itsource.xigou.query.BrandQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<Brand> brandPageList(Page<Brand> page, BrandQuery brandQuery);
}
