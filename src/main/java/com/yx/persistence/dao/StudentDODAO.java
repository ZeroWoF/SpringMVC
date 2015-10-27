package com.yx.persistence.dao;

import com.yx.model.StudentDO;
import com.yx.model.StudentDOExample;
import java.util.List;

public interface StudentDODAO {
    int countByExample(StudentDOExample example);

    int deleteByExample(StudentDOExample example);

    int deleteByPrimaryKey(String studentId);

    void insert(StudentDO record);

    void insertSelective(StudentDO record);

    List<StudentDO> selectByExample(StudentDOExample example);

    StudentDO selectByPrimaryKey(String studentId);

    int updateByExampleSelective(StudentDO record, StudentDOExample example);

    int updateByExample(StudentDO record, StudentDOExample example);

    int updateByPrimaryKeySelective(StudentDO record);

    int updateByPrimaryKey(StudentDO record);
}