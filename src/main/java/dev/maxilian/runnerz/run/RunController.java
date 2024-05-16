package dev.maxilian.runnerz.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/runs")
public class RunController {

 private final RunRepository runRepository;

 // @Autowired
 public RunController(RunRepository runRepository){
  this.runRepository = runRepository;
 }
 
 @GetMapping("")
 List<Run> findAll(){
  return runRepository.findAll();
 }

 @GetMapping("/{id}")
 Run findById(@PathVariable Integer id){

  Optional<Run> run = runRepository.findById(id);
  if(run.isEmpty()){
   throw new RunNotFoundException();
   // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
  }
  return run.get();
  // return runRepository.findById(id);
 }

 // @GetMapping("/hello")
 // String home(){
 //  return "Hello, Runnerz!";
 // }

 // post
 @ResponseStatus(HttpStatus.CREATED)
 @PostMapping("")
 void create(@Valid @RequestBody Run run){
  runRepository.create(run);
 }

 // put
 @ResponseStatus(HttpStatus.NO_CONTENT)
 @PutMapping("/{id}")
 void update(@Valid @RequestBody Run run, @PathVariable Integer id){
  runRepository.update(run, id);
 }

 // delete
 @ResponseStatus(HttpStatus.NO_CONTENT)
 @DeleteMapping("/{id}")
 void delete(@PathVariable Integer id){
  runRepository.delete(id);
 }

}
