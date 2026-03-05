package com.intern.tailorshop.service.implemantation;

import com.intern.tailorshop.domain.TailorShop;
import com.intern.tailorshop.exception.customized.ShopNotFoundException;
import com.intern.tailorshop.proxy.TailorShopProxy;
import com.intern.tailorshop.repository.TailorShopRepo;
import com.intern.tailorshop.service.ShopService;
import com.intern.tailorshop.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private TailorShopRepo tailorShopRepo;

    @Autowired
    private MapperHelper mapperHelper;

    @Override
    public TailorShopProxy createShop(TailorShopProxy proxy) {
        TailorShop shop = mapperHelper.getEntityFromProxy(proxy);
        TailorShop save = tailorShopRepo.save(shop);
        return mapperHelper.getProxyFromEntity(save);
    }

    @Override
    public TailorShopProxy updateShop(Long shopId, TailorShopProxy proxy) {
        Optional<TailorShop> optShop = tailorShopRepo.findById(shopId);
        if(!optShop.isPresent())
            throw new ShopNotFoundException("There is no shop found with id "+shopId);

        TailorShop tailorShop = optShop.get();
        TailorShop updatedShop = mapperHelper.getEntityFromProxy(proxy);
        updatedShop.setShopId(tailorShop.getShopId());
        return mapperHelper.getProxyFromEntity(tailorShopRepo.save(updatedShop));
    }

    @Override
    public void deactivateShop(Long shopId) {
        Optional<TailorShop> optShop = tailorShopRepo.findById(shopId);
        if(!optShop.isPresent())
            throw new ShopNotFoundException("There is no shop found with id "+shopId);

        TailorShop tailorShop = optShop.get();

        tailorShop.setStatus("Deactivated Shop");

        tailorShopRepo.save(tailorShop);
    }

    @Override
    public List<TailorShopProxy> getAllShops() {
        List<TailorShop> all = tailorShopRepo.findAll();

        List<TailorShopProxy> list = all.stream().map(s -> mapperHelper.getProxyFromEntity(s)).toList();

        return list;
    }

    @Override
    public TailorShopProxy getShopById(Long shopId) {
        Optional<TailorShop> optShop = tailorShopRepo.findById(shopId);
        if(!optShop.isPresent())
            throw new ShopNotFoundException("There is no shop found with id "+shopId);
        return mapperHelper.getProxyFromEntity(optShop.get());
    }

    @Override
    public String deleteShopById(Long shopId) {
        Optional<TailorShop> optShop = tailorShopRepo.findById(shopId);
        if(!optShop.isPresent())
            throw new ShopNotFoundException("There is no shop found with id "+shopId);

        tailorShopRepo.deleteById(shopId);

        return "Shop with id "+shopId+" has been deleted successfully";
    }
}
