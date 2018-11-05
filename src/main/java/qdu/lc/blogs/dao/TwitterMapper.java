package qdu.lc.blogs.dao;

import qdu.lc.blogs.model.Twitter;

public interface TwitterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Twitter record);

    int insertSelective(Twitter record);

    Twitter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Twitter record);

    int updateByPrimaryKey(Twitter record);
}