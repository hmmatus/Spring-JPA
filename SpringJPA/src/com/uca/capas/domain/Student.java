package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="student")
public class Student {
	
	@Id
	@Column(name="id_student")
	private Integer cStudent;
	
	@Column(name="s_name")
	private String sName;
	
	@Column(name="s_lname")
	private String lName;
	
	@Column(name="s_age")
	private Integer sAge;
	
	@Column(name="b_active")
	private Boolean bActivo;

	//Constructores, Setters y Getters
	public Student(Integer cCLiente, String sName, String lName, Integer sAge, Boolean bActivo) {
		super();
		this.cStudent = cCLiente;
		this.sName = sName;
		this.lName = lName;
		this.sAge = sAge;
		this.bActivo = bActivo;
	}
	
	public Student() {
		super();
	}





	//Setters y Getters
	public Integer getcCLiente() {
		return cStudent;
	}

	
	public void setcCLiente(Integer cCLiente) {
		this.cStudent = cCLiente;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public Boolean getbActivo() {
		return bActivo;
	}

	public void setbActivo(Boolean bActivo) {
		this.bActivo = bActivo;
	}
	
	//Funciones delegate
	public String getActivoDelegate() {
		if(this.bActivo == null) return "";
		else {
			return bActivo == true ?"Activo":"Inactivo";
		}
	}
	
	/*public String getFechaDelegate() {
		if(this.bDate == null) return "";
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(this.bDate.getTime());
		}
	}*/
	
}
