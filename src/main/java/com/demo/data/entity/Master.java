package com.demo.data.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.demo.data.converter.BooleanConverter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(schema = "SCHEMA1", name = "MASTER_TBL")
public class Master {

	@Id
	@Column(name = "MASTER_ID")
	private Long id; // MASTER_ID NOT NULL NUMBER
	
	@Column(name = "MASTER_NAME")
	private String name;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	// convert the String[Y/N] to Boolean[true/false]
	@Convert( converter = BooleanConverter.class )
	@Column(name = "DISABLED_FLAG")
	private Boolean disabled; // DISABLED_FLAG VARCHAR2(1)

	// Mapping
	// FetchType.LAZY => query the detail data when using the getDetails().
	// FetchType.EAGER => query this master with details at the same time.
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "master", fetch = FetchType.LAZY)
//	private Set<Detail> details;
	

}
