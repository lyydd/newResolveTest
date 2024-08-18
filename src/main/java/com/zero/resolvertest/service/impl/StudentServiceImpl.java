package com.zero.resolvertest.service.impl;

import com.zero.resolvertest.mapper.StudentMapper;
import com.zero.resolvertest.pojo.entity.Student;
import com.zero.resolvertest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: ResolverTest
 * @BelongsPackage: com.zero.resolvertest.service.impl
 * @Author: zero
 * @CreateTime: 2024-07-16  14:37
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper userMapper;
    @Override
    public Student getById(Long id) {
        if(id!=null){
            return userMapper.getById(id);
        }else{
            return null;
        }
    }

    @Override
    public void save(Student student) {
        userMapper.save(student);
    }



    @Override
    public Boolean deleteById(Long id) {
        userMapper.deleteUser(id);
        return true;
    }

    @Override
    public Boolean updateById(Student student) {
        userMapper.updateById(student);
        return true;
    }

    @Override
    public String register(Long id) {
        if(id==1){
            return userMapper.addUser(id);
        }else if(id==2){
            userMapper.deleteUser(id);
            return "id==2";
        }else{
            return "id不正确";
        }
    }

    @Override
    public Boolean createConsumerDetails(String email) {
        if(email.endsWith("@icbc.cn")){
            userMapper.saveUserDetail(email);
        }else if(email.endsWith("@icac.cn")){
            Long id1=12L;
            userMapper.saveUserDetail(id1,email);
        }else{
            Long id=6L;
            userMapper.updateBatch(id,email);
        }
        return true;
    }

    @Override
    public Boolean modifyConsumerDetails(Long id, String name) {
        if(name==null){
            return false;
        }else if(name.equals("Jacky Cheng")){
            userMapper.updateUserDetail(id,name);
        }else if(name.equals("Juice Lily")){
            if(id==10){
                userMapper.saveUserDetail(name);
            }else if(id>20){
                Long id1=id*id;
                userMapper.saveUserDetail(id1,name);
            }
        }else if(name.equals("小阳") &&id!=3){
            if(id<0){
                userMapper.deleteUser(id);
            }
        }else{
            userMapper.updateBatch(id,name);
        }
        return true;
    }

    @Override
    public Boolean saveByCertain(String name) {
        Long id2= 9L;
        userMapper.saveByCertain(id2,name);
        return true;
    }
}
