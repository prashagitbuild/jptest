package com.jptest.epc.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jptest.epc.handlers.ResourceNotFoundException;
import com.jptest.epc.models.EPCResponse;
import com.jptest.epc.models.Signals;

@Component
public interface EPCService {
	List<Signals> findAll();
	Signals createSignal(Signals signal);
	Signals updateSignal(String name,Signals signal)throws ResourceNotFoundException ;
	Signals findSignalByName(String name);
	List<EPCResponse> simulatePedCrossing(Signals signal) throws ResourceNotFoundException;
}
