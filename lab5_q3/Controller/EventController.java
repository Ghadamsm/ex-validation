package com.example.lab5_q3.Controller;
import com.example.lab5_q3.API.ApiResponse;
import com.example.lab5_q3.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Event> getEvents(){
        return events ;
    }


    @PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody @Valid Event event , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.add(event);

        return ResponseEntity.status(200).body( new ApiResponse("added"));
    }


    @PutMapping("/update/{index}")
    public ResponseEntity updateEvent(@PathVariable int index , @RequestBody @Valid Event event , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        events.set(index , event);

        return ResponseEntity.status(200).body( new ApiResponse("updated"));
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent (@PathVariable int index){

        events.remove(index);

        return new ApiResponse("delete");
    }


    @PutMapping("/change/{index}/{Cap}")
    public ApiResponse changeCap(@PathVariable String index ,@PathVariable int Cap){

        for (Event event : events){
            if (event.getID().contains(index)){
            event.setCapacity(Cap);
        }}

        return new ApiResponse("Changed");
    }



    @GetMapping("/search/{Id}")
    public ApiResponse searchID(@PathVariable String Id){
        for (Event event : events){
           if( event.getID().contains(Id)){
            return new ApiResponse("found : " + Id);
        }}

        return new ApiResponse("not found");

    }


}
