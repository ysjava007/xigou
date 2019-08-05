package cn.itsource.xigou.service.impl;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.common.RedisClient;
import cn.itsource.xigou.domain.ProductType;
import cn.itsource.xigou.mapper.ProductTypeMapper;
import cn.itsource.xigou.service.IProductTypeService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author ysjaava007
 * @since 2019-08-01
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private RedisClient redisClient;

    private List<ProductType> qureyProductTypes(){
        List<ProductType> productTypes = baseMapper.selectList(null);
        List<ProductType> list = new ArrayList<>();
        Map<Long,ProductType> map=new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(), productType);
        }
        for (ProductType productType : productTypes) {
            if(productType.getPid()==0){
                list.add(productType);
            }else {
                ProductType parent=map.get(productType.getPid());
                List<ProductType> children = parent.getChildren();
                if(children==null){
                    children=new ArrayList<>();
                }
                children.add(productType);
                parent.setChildren(children);

            }
        }


        return list;
    }

    @Override
    public List<ProductType> listJ(){
        AjaxResult ajaxResult = redisClient.get("productTypes");
        String restObj = (String) ajaxResult.getRestObj();
        List<ProductType> productTypes = JSON.parseArray(restObj, ProductType.class);
        if(productTypes==null||productTypes.size()<=0){
            productTypes=qureyProductTypes();
            redisClient.set("productTypes", JSON.toJSONString(productTypes));
        }

        return productTypes;
    }

}
