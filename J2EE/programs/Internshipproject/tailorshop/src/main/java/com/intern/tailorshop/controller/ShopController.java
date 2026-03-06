package com.intern.tailorshop.controller;

import com.intern.tailorshop.proxy.TailorShopProxy;
import com.intern.tailorshop.service.implementation.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/shop")
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @PostMapping(value = "/create-shop")
    public ResponseEntity<TailorShopProxy> createShop(@RequestBody TailorShopProxy proxy){
        TailorShopProxy shop = shopService.createShop(proxy);
        return new ResponseEntity<>(shop , HttpStatus.CREATED);
    }

    @PostMapping(value = "/update-shop/{shopId}")
    public ResponseEntity<TailorShopProxy> updateShop(@PathVariable Long shopId , @RequestBody TailorShopProxy proxy){
        TailorShopProxy tailorShopProxy = shopService.updateShop(shopId, proxy);
        return new ResponseEntity<>(tailorShopProxy , HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TailorShopProxy>> getAllShop(){
        return new ResponseEntity<>(shopService.getAllShops() , HttpStatus.OK);
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<TailorShopProxy> getShopById(@PathVariable Long shopId){
        return new ResponseEntity<>(shopService.getShopById(shopId) , HttpStatus.OK);
    }

    @GetMapping(value = "deactivate/{shopId}")
    public void deactivateShop(@PathVariable Long shopId){
        shopService.deactivateShop(shopId);
    }

    @DeleteMapping(value = "/{shopId}")
    public ResponseEntity<String> deleteShop(@PathVariable Long shopId){
        return new ResponseEntity<>(shopService.deleteShopById(shopId) , HttpStatus.OK);
    }

}
