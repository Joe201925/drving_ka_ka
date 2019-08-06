package com.qf.dao;

import com.qf.bean.Finished;

public interface FinishedMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Finished record);

    int insertSelective(Finished record);

    Finished selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Finished record);

    int updateByPrimaryKey(Finished record);
}