package dev.maxilian.runnerz.run;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class RunController {

 private final RunRepository runRepository;

 // @Autowired
 public RunController(RunRepository runRepository){
  this.runRepository = runRepository;
 }
 
 @GetMapping("/api/runs")
 List<Run> findAll(){
  return runRepository.findAll();
 }



 // @GetMapping("/hello")
 // String home(){
 //  return "Hello, Runnerz!";
 // }

}
