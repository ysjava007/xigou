package cn.itsource.xigou.service.impl;

import cn.itsource.xigou.domain.Product;
import cn.itsource.xigou.mapper.ProductMapper;
import cn.itsource.xigou.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
