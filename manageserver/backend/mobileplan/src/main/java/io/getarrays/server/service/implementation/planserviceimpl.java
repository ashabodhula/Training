package io.getarrays.server.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Plan;
import io.getarrays.server.repository.PlanRepository;
import io.getarrays.server.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // promoted dependency injection
@Transactional
@Slf4j  //log
@Service

public class planserviceimpl implements PlanService
{
	private final PlanRepository planRepo;

	@Override
	public Plan Create(Plan plan) {
		log.info("Saving new  plan:{}",plan.getName());
	    plan.setImageurl(setPlanImageUrl());
		return planRepo.save(plan);
	}

	private String setPlanImageUrl() {
		String[] imageNames = {"image1.png","image2.png","image3.png"};
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/plan/image/"+imageNames[new Random().nextInt(3)]).toUriString();
	}

	@Override
	public Collection<Plan> list(int limit) {
		//log.info("Fetching all plans:{}");
		
		return planRepo.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Plan get(Long id) {
		log.info("Fetching plan by plan id :{}");
		
		return planRepo.findById(id).get();
	}

	@Override
	public Plan update(Plan plan) {
		log.info("Update plan :{}", plan.getName());
		
		
		
		return planRepo.save(plan);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Delete plan by plan id :{}", id);
		planRepo.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public Plan ping(String ipAddress) throws IOException {
		log.info("Pinging IP:{}",ipAddress);
		Plan plan = planRepo.findByIpAddress(ipAddress);
		InetAddress address =InetAddress.getByName(ipAddress);
		plan.setStatus(address.isReachable(10000) ? Status.PLAN_ACTIVE :Status. PLAN_NOTACTIVE);
		planRepo.save(plan);
		return plan;
		
		
	}

}
