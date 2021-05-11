package com.jptest.epc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jptest.epc.handlers.ResourceNotFoundException;
import com.jptest.epc.models.EPCResponse;
import com.jptest.epc.models.Signals;
import com.jptest.epc.services.EPCService;

@Component
@RestController
@RequestMapping("/api/")
//@ComponentScan("com.jptest.epc.sevices")
public class EPCController {

	@Autowired
	@Qualifier("epcService")
	EPCService epcService;
  /**
   * Get all Signals list.
   *
   * @return the list
   */
  @GetMapping("/signals")
  public List<Signals> getAllSignals() {
	  return epcService.findAll();  
  }
  
  @GetMapping("/signals/{name}")
  public ResponseEntity<Signals> getSignalByName(@PathVariable(value = "name") String name) throws ResourceNotFoundException{
	  return ResponseEntity.ok(epcService.findSignalByName(name));  
  }

  /**
   * Create Signals.
 
   */
  @PostMapping("/createSignal")
  public ResponseEntity<Signals> createSignal(@RequestBody Signals signal) {
	  return ResponseEntity.ok(epcService.createSignal(signal));
  }
  
  @PutMapping("/employees/{name}")
  public ResponseEntity<Signals> updateEmployee(@PathVariable(value = "name") String name,@RequestBody Signals signal) throws ResourceNotFoundException {
      return ResponseEntity.ok(epcService.updateSignal(name,signal));
  }
  
  @PostMapping("/simulatePedCrossing")
  public ResponseEntity<List<EPCResponse>> simulatePedestrianCrossing(@RequestBody Signals signal)throws ResourceNotFoundException {
	  List<EPCResponse> response = epcService.simulatePedCrossing(signal);
	  if(response == null){
		  throw new ResourceNotFoundException("Signal not found for :: " + signal.getName());
	  }
	  return ResponseEntity.ok(response);
  }

  
}
