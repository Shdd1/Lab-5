package com.example.lab5q3.Controller;

import com.example.lab5q3.ApiResponse.Response;
import com.example.lab5q3.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//********************Q3***********************8
@RestController
@RequestMapping("/api/v3/event")
public class EventSystem {
    ArrayList<Event> events = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Event> getEvent(){
        return events;
    }
    @PostMapping("/add")
    public Response addEvent(@RequestBody Event event){
        events.add(event);
        return new Response("Success add") ;
    }
    @PutMapping("/update/{index}")
    public Response updateEvent(@PathVariable int index,@RequestBody Event event){
        events.set(index, event);
        return new Response("Success Update");
    }
    @DeleteMapping("/delete")
    public Response deletEvent(@PathVariable int index){

        events.remove(index);
        return new Response("Success remove");
    }
    @PutMapping("/change/{index}/{number}")
   public Response changeCap(@PathVariable int index,@PathVariable int number){
        events.get(index).setCapacity(number);
        return new Response("Success change");
   }
   @GetMapping("/search/{id}")
   public Event searchEvent(@PathVariable int id){
        for (Event e:events){
            if(e.getId().equals(id)){

            }
            return e;
        }
         return null;
   }


}
