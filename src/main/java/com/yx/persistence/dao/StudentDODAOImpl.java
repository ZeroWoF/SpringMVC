package com.yx.persistence.dao;

import com.yx.model.StudentDO;
import com.yx.model.StudentDOExample;
import java.util.List;

import com.yx.persistence.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class StudentDODAOImpl extends SqlMapClientDaoSupport implements com.yx.persistence.dao.StudentDODAO {


    public StudentDODAOImpl() {
        super();
    }

    public int countByExample(StudentDOExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("student.countByExample", example);
        return count;
    }

    public int deleteByExample(StudentDOExample example) {
        int rows = getSqlMapClientTemplate().delete("student.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String studentId) {
        StudentDO _key = new StudentDO();
        _key.setStudentId(studentId);
        int rows = getSqlMapClientTemplate().delete("student.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(StudentDO record) {
        getSqlMapClientTemplate().insert("student.insert", record);
    }

    public void insertSelective(StudentDO record) {
        getSqlMapClientTemplate().insert("student.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<StudentDO> selectByExample(StudentDOExample example) {
        List<StudentDO> list = getSqlMapClientTemplate().queryForList("student.selectByExample", example);
        return list;
    }

    public StudentDO selectByPrimaryKey(String studentId) {
        StudentDO _key = new StudentDO();
        _key.setStudentId(studentId);
        StudentDO record = (StudentDO) getSqlMapClientTemplate().queryForObject("student.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(StudentDO record, StudentDOExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("student.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(StudentDO record, StudentDOExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("student.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(StudentDO record) {
        int rows = getSqlMapClientTemplate().update("student.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(StudentDO record) {
        int rows = getSqlMapClientTemplate().update("student.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends StudentDOExample {
        private Object record;

        public UpdateByExampleParms(Object record, StudentDOExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}