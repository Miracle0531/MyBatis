package com.itheima.mybatis04.pojo;

/**
 * <p>Titel:OrderCustom</p>
 * <p>Description:自定义订单实体类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 20:26
 */
@SuppressWarnings("all")
public class OrderCustom extends Orders {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
