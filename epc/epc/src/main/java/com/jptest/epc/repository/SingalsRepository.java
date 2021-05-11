package com.jptest.epc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jptest.epc.models.Signals;

@Repository
public interface SingalsRepository extends JpaRepository<Signals, Long>{
	 List<Signals> findByName(String name);
}
