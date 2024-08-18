package com.zero.resolvertest.controller.student;

import com.zero.resolvertest.pojo.entity.Student;
import com.zero.resolvertest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: ResolverTest
 * @BelongsPackage: com.zero.resolvertest.controller.student
 * @Author: zero
 * @CreateTime: 2024-07-16  14:32
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Boolean save(@RequestBody Student student){
        studentService.save(student);
        return true;
    }

    @PostMapping("/update")
    public Boolean updateById(@RequestBody Student student){
        studentService.updateById(student);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return studentService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getById(id);
    }
    @GetMapping("/information")
    public String getInformation(@RequestParam("id")Long id,@RequestParam("status") Integer status){
        if(status==0){
            return studentService.getById(id).getName();
        }else if(status==1){
            return studentService.register(id);
        }else{
            return null;
        }

    }
    @PostMapping("/save01")
    public Boolean changeConsumerDetails(@RequestParam("id")Long id,@RequestParam("type")String type,@RequestParam("name")String name){
        if(id==1&& type.equals("CREATE_CONSUMER")){
            return studentService.createConsumerDetails(name);
        }else if(id!=null&& type.equals("UPDATE_CONSUMER")){
            return studentService.modifyConsumerDetails(id,name);
        }else{
            return studentService.saveByCertain(name);
        }
    }


}
