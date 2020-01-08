package com.demo.data.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.demo.data.converter.ProgramLanguageConverter;
import com.demo.data.property.ProgramLanguageType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(schema = "SCHEMA1", name = "DETAIL_TBL")
public class Detail {

	@Id
	@Column(name = "DETAIL_ID")
	private Long id; 
	
	@Id
	@Column(name = "MASTER_ID")
	private Long masterId; 
	
	@Column(name = "DETAIL_NAME")
	private String name;
	
	// Convert to enum.
	@Convert( converter = ProgramLanguageConverter.class )
	@Column(name = "PROG_LANG")
	private ProgramLanguageType programLanguage;

//	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//	@JoinColumn(name = "MASTER_ID") 
//	private Master master;

}
