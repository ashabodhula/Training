package io.getarrays.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import io.getarrays.server.enumeration.Type;
import io.getarrays.server.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique=true)
	@NotEmpty(message="Ip address cannot be empty or null")
	private String ipAddress;
	@Column(unique=true)
	@NotBlank(message = "Plan Details cannot be empty ")
	private String planDetails;
	@NotBlank(message = "Plan name cannot be empty ")
	private String name;
	private double price;
	private Type type;
	private String imageurl;
	private Status status;
}
