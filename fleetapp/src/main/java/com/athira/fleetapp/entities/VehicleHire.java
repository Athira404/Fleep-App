package com.athira.fleetapp.entities;

import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleHire {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private Integer vehicleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateOut;
	
	private String timeOut;//time, when they hired the vehicle
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateIn;
	
	private String timeIn;//time, when they returned the vehicle
	
	@ManyToOne
	@JoinColumn(name="clientid", insertable=false, updatable=false)
	private Client client;
	private Integer clientid;//who hired the vehicle
	
	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)
	private Location location;
	private Integer locationid;//where they have taken the vehicle
	
	private String price;
	
	private String remarks;
}
