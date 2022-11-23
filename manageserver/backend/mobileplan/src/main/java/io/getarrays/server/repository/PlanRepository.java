package io.getarrays.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.server.model.Plan;

public interface PlanRepository extends JpaRepository <Plan,Long>{
	Plan findByPlanDetails(String planDetails);
//	Plan findByName(String name);
	Plan findByIpAddress(String ipAddress);

}
