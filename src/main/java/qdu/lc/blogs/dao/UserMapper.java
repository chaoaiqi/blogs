package qdu.lc.blogs.dao;

import qdu.lc.blogs.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String telephone);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String telephone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}