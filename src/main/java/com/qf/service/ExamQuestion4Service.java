package com.qf.service;

import com.qf.bean.ExaminationQuestion4;
import com.qf.bean.Finished;

import java.util.List;

public interface ExamQuestion4Service {

    //主键查询
    ExaminationQuestion4 findById(Integer id);

    //错题增加
    int insertFinished(Finished finished);

    //模拟考试
    List<ExaminationQuestion4> selectAll(Integer model);

    //随机练习
    List<ExaminationQuestion4> selectForRandom();

    //专项练习
    List<ExaminationQuestion4> selectAllForSpec(Integer tid);

    //优先做未做题
    List<ExaminationQuestion4> selectUndo();
}
