package io.getarrays.server.service;

import java.io.IOException;
import java.util.Collection;

import io.getarrays.server.model.Plan;

public interface PlanService {

	Plan Create(Plan plan);
	
	Plan ping(String ipAddress) throws IOException;

	Collection<Plan> list(int limit);

	Plan get(Long id);

	Plan update(Plan plan);

	Boolean delete(Long id);

}
