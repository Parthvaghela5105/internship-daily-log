package com.intern.tailorshop.util;

import com.intern.tailorshop.domain.TailorShop;
import com.intern.tailorshop.proxy.TailorShopProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MapperHelper {
    @Autowired
    private ObjectMapper mapper;

    public TailorShopProxy getProxyFromEntity(TailorShop shop){
        return mapper.convertValue(shop , TailorShopProxy.class);
    }

    public TailorShop getEntityFromProxy(TailorShopProxy proxy){
        return mapper.convertValue(proxy , TailorShop.class);
    }


}
