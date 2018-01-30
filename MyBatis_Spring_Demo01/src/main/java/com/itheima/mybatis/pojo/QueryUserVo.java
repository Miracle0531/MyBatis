package com.itheima.mybatis.pojo;

import java.util.List;

/**
 * <p>Titel:QueryUserVo</p>
 * <p>Description:用户信息的包装对象类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 17:15
 */
@SuppressWarnings("all")
public class QueryUserVo {

    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
