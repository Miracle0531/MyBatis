package com.itheima.mybatis03.pojo;

import java.util.List;

/**
 * <p>Titel:QueryUserVo</p>
 * <p>Description:映射对象实体类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 15:57
 */
@SuppressWarnings("all")
public class QueryUserVo {

    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
