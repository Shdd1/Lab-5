package com.example.demo.Controller;

import com.example.demo.model.Project;
import com.example.demo.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//***************Q2***************
@RestController
@RequestMapping("/api/v2/tracker")
public class TrackerSystem {
    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getProject() {
        return projects;
    }
    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("Success add");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index,@RequestBody Project project){
        projects.set(index,project);
        return new ApiResponse("Success update");
    }
    @DeleteMapping("/update/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("Success remove");
    }
    @PutMapping("/updates/{index}")
    public ApiResponse statusPro(@PathVariable int index){
        if(projects.get(index).getStatus().equalsIgnoreCase("not done")){
            projects.get(index).setStatus("Done");
        }
        return new ApiResponse("Success change");
    }
    @GetMapping("/search/{title}")
    public Project searchPro(@PathVariable String title){
        for (Project p:projects){
           if(p.getTitle().equalsIgnoreCase(title)) {
               return p;
           }
        }
        return null ;
    }

    @GetMapping("/display/{company}")
    public ArrayList<Project> allProject(@PathVariable String company){
        ArrayList<Project>companyes=new ArrayList<>();
        for (Project p:projects){
            if(p.getCompanyName().equalsIgnoreCase(company)) {
                companyes.add(p);
            }

        }
        return companyes;
    }






}
