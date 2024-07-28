package com.example.lab5.Controller;

import com.example.lab5.model.Student;
import com.example.lab5.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//*******************Q1********************
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Student> getStudent() {
        return students;
    }
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student  student){
        students.add(student);
        return new ApiResponse("Success Add");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student){
        students.set(index,student);
        return new ApiResponse("Success Update");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Success Delete");
    }

   @GetMapping("/name/{id}")
    public String getName(@PathVariable String id) {
       for (Student s : students) {
          if(s.getId().equalsIgnoreCase(id)) {
              return"this student name : "+ s.getName();
          }else{
              return "There is no student with this id";
          }
       }
       return null;
   }

    @GetMapping("/age/{id}")
    public String getAge(@PathVariable String id) {
        for (Student a : students) {
            if (a.getId().equals(id)) {
                return a.getAge();
            } else {
                return "There is no student with this id";
            }

        }
        return null;
   }
   @GetMapping("/degree/{id}")
   public String getDegree(@PathVariable String id){
        for(Student d:students){
            if(d.getId().equals(id)){
                return d.getDegree();
            }else {
                return "There is no student with this id";
            }

        }
        return null;
   }
   @GetMapping("/status/{id}")
   public ApiResponse getStatus(@PathVariable String id){
        for(Student s:students){
            if(s.getId().equals(id)) {
                if (s.getStatus().equalsIgnoreCase("graduated")) {
                    return new ApiResponse("is graduated? true");
                } else
                    return new ApiResponse( "is graduated? false");
            }
        }
        return new ApiResponse(" \"There is no student with this id\" ") ;
   }






}
