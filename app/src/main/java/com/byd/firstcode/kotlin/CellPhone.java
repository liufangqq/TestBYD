package com.byd.firstcode.kotlin;

import java.util.Objects;

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/08/17
 * desc :
 * version: 1.0
 * </pre>
 */
public class CellPhone {
    String brand;
    double price;
    public CellPhone(  String brand,double price){
        this.brand = brand;
        this.price=price;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof CellPhone){
           CellPhone other = (CellPhone) obj;
           return other.brand.equals(brand) && other.price==price;
       }
       return false;
    }

    @Override
    public int hashCode() {
        return brand.hashCode()+(int) price;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
