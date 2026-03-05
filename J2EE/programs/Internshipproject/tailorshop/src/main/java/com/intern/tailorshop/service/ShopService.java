package com.intern.tailorshop.service;

import com.intern.tailorshop.domain.TailorShop;
import com.intern.tailorshop.proxy.TailorShopProxy;

import java.util.List;

public interface ShopService {
    TailorShopProxy createShop(TailorShopProxy proxy);

    TailorShopProxy updateShop(Long shopId , TailorShopProxy proxy);

    void deactivateShop(Long shopId);

    List<TailorShopProxy> getAllShops();

    TailorShopProxy getShopById(Long shopId);

    String deleteShopById(Long shopId);
}
