package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="section")
public class Section {
	
	@Id
	@GeneratedValue(generator="section_id_section_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="section_id_section_seq",sequenceName="public.section_id_section_seq",allocationSize = 1)
	@Column(name="id_section")
	private Integer cSection;
	
	@Column(name="sec_name")
	private String secName;
	
	@Column(name="teacher_name")
	private String tName;
	
	@OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
	private List<Student> students;
	
	public Section() {

	}

	public Section(Integer cSection, String secName, String tName, List<Student> students) {
		super();
		this.cSection = cSection;
		this.secName = secName;
		this.tName = tName;
		this.students = students;
	}

	public Integer getcSection() {
		return cSection;
	}

	public void setcSection(Integer cSection) {
		this.cSection = cSection;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
