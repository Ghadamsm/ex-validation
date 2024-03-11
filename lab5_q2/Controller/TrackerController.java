package com.example.lab5_q2.Controller;

import com.example.lab5_q2.API.ApiResponse;
import com.example.lab5_q2.Model.Tracker;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {

ArrayList<Tracker> trackers = new ArrayList<>();


        @GetMapping("/get")
        public ArrayList<Tracker> getTrackers(){
        return trackers;
        }

        @PostMapping("/add")
        public ResponseEntity addTracker(@RequestBody @Valid Tracker tracker , Errors errors){

                if (errors.hasErrors()){
                        String message = errors.getFieldError().getDefaultMessage();
                        return ResponseEntity.status(400).body(message);
                }

                trackers.add(tracker);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
        }


        @PutMapping("/update/{index}")
        public ResponseEntity updateTracker(@PathVariable int index , @RequestBody @Valid Tracker tracker , Errors errors){

                if (errors.hasErrors()){
                        String message = errors.getFieldError().getDefaultMessage();
                        return ResponseEntity.status(400).body(message);
                }

                trackers.set(index , tracker);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }


        @DeleteMapping("/delete/{index}")
        public ApiResponse deleteTracker(@PathVariable int index){

                trackers.remove(index);

        return new ApiResponse("done!");
        }


        @PutMapping("/change/{index}")
        public ApiResponse changeTracker(@PathVariable int index){

        if (trackers.get(index).getStatus().equals("not done")){
                trackers.get(index).setStatus("done");
                return new ApiResponse("Good!");
        } else {
                return new ApiResponse("Invalid");

        }

        }

        @GetMapping("/search/{search}")
        public ArrayList<Tracker> searchTitle(@PathVariable String search){

        ArrayList<Tracker> trackerArrayList = new ArrayList<>();
               for (Tracker tracker : trackers){
                       if (tracker.getTitle().contains(search)){
                               trackerArrayList.add(tracker);
                       }
               }
        return trackerArrayList;
}

        @GetMapping("/display/{company}")
        public ArrayList<Tracker> displayProject(@PathVariable String company){
                ArrayList<Tracker> displayArray = new ArrayList<>();

                for (Tracker tracker : trackers){
                        if (tracker.getCompanyName().contains(company)){
                                displayArray.add(tracker);
                        }
                }

                return displayArray;

}

}
