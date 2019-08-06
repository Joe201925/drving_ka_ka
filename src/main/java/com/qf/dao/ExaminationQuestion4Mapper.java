package com.qf.dao;

import com.qf.bean.ExaminationQuestion4;

import java.util.List;

public interface ExaminationQuestion4Mapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(ExaminationQuestion4 record);

    int insertSelective(ExaminationQuestion4 record);

    ExaminationQuestion4 selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(ExaminationQuestion4 record);

    int updateByPrimaryKey(ExaminationQuestion4 record);

    //模拟考试
    List<ExaminationQuestion4> findAll();
    //专项练习
    List<ExaminationQuestion4> findByTid(Integer tid);

    //随机练习
    List<ExaminationQuestion4> findByRandom();

    //优先做未做题
    List<ExaminationQuestion4> selectUndo();
}