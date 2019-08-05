package cn.itsource.xigou.service;

import cn.itsource.basic.util.PageList;
import cn.itsource.xigou.domain.Brand;
import cn.itsource.xigou.query.BrandQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
public interface IBrandService extends IService<Brand> {
    PageList<Brand> brandPageList(BrandQuery brandQuery);

}
