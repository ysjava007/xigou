package cn.itsource.xigou.service;

import cn.itsource.xigou.domain.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
public interface IProductTypeService extends IService<ProductType> {
    public List<ProductType> listJ();
}
