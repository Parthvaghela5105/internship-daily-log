package com.intern.manytomany.proxy;

import lombok.Data;

import java.util.List;

@Data
public class StudentProxy {
    private Long id;
    private String name;
    private String emailId;
    private List<AddressProxy> addressProxyList;
}
