package com.jptest.epc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jptest.epc.handlers.ResourceNotFoundException;
import com.jptest.epc.models.EPCResponse;
import com.jptest.epc.models.Signals;
import com.jptest.epc.repository.SingalsRepository;

//@CacheConfig(cacheNames={"signals"})   

@Service("epcService")
public class EPCServiceImpl implements EPCService{

	@Autowired
	SingalsRepository singalsRepository;
	
	
	@Override
	public List<Signals> findAll() {
		// TODO Auto-generated method stub
		 return singalsRepository.findAll();
	}

	@Override
	public Signals findSignalByName(String name) {
		// TODO Auto-generated method stub
		return singalsRepository.findByName(name).get(0);
	}

	@Override
	public Signals createSignal(Signals signal) {
		// TODO Auto-generated method stub
		return singalsRepository.save(signal);
	}

	@Override
	public Signals updateSignal(String name,Signals signal)throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		Signals matchedsignal = singalsRepository.findByName(name).get(0);
				
		if(matchedsignal == null)
			throw new ResourceNotFoundException("Signal not found for :: " + name);
		else{
			signal.setNoOfPedestrianWaitingToCross(matchedsignal.getNoOfPedestrianWaitingToCross());
			signal.setId(matchedsignal.getId());
			final Signals updatedSignal = singalsRepository.save(signal);
			return updatedSignal;
		}
	}

	@Override
	public List<EPCResponse> simulatePedCrossing(Signals signal) {
		// TODO Auto-generated method stub
		List<EPCResponse> responseList = new ArrayList<EPCResponse>();
		Signals matchedsignal = singalsRepository.findByName(signal.getName()).get(0);
		if(matchedsignal == null){
			return null;
		}else{
			Integer noOfPeopleAllowed = Integer.parseInt(matchedsignal.getNoOfPeopleAllowed());
			Integer noOfPedestrianWaiting = Integer.parseInt(signal.getNoOfPedestrianWaitingToCross());
			Integer waitingPeriodInSec = Integer.parseInt(matchedsignal.getWatingPeriodInSec());
			int timeToChangeSignal = 0;
			if(waitingPeriodInSec != 0){
				timeToChangeSignal = waitingPeriodInSec/noOfPedestrianWaiting;
			}
			
			if(timeToChangeSignal == 0)
				timeToChangeSignal = waitingPeriodInSec;
			int count = timeToChangeSignal;
			//int iterationCount = noOfPedestrianWaiting/noOfPeopleAllowed;
			int i = 0;
			if(noOfPedestrianWaiting < noOfPeopleAllowed){
				EPCResponse response = new EPCResponse();
				response.setTimeRequire(timeToChangeSignal + " Sec");
				response.setNoOfPedAllowedToPass(noOfPedestrianWaiting);
				responseList.add(response);
			}else{
				while(noOfPedestrianWaiting > 0){
					EPCResponse response = new EPCResponse();
					
					if(i != 0)
						timeToChangeSignal+=timeToChangeSignal;
					
					response.setTimeRequire(timeToChangeSignal + " Sec");
					
					if(noOfPeopleAllowed < noOfPedestrianWaiting)
						response.setNoOfPedAllowedToPass(noOfPeopleAllowed);
					else
						response.setNoOfPedAllowedToPass(noOfPedestrianWaiting);
						
					responseList.add(response);
					noOfPedestrianWaiting = noOfPedestrianWaiting - noOfPeopleAllowed;
					
					i++;
				}
			}
		}
		
		return responseList;
	}

}
