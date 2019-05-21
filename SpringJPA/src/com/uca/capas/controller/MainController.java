package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;
import com.uca.capas.repositories.StudentRepository;

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/

@Controller
public class MainController {
	
	
	//Objeto Logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	//Objeto Singleton
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private StudentRepository studentRepo;
	
	//Controlador principal
	@RequestMapping("/")
	public ModelAndView initMain(){
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
		//Selecciono todos los elementos de la tabla student
		 students = studentDao.findAll();
		 log.info("Termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	//Controlador para busquedas por codigo
	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseBody
	public Student search(@RequestParam(value = "code") Integer code) {
		Student student = studentDao.findOne(code);
		return student;
		
	}
	
	//Controlador que lleva a formulario
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav; 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@RequestParam(value="code") Integer code) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",studentDao.findOne(code));
		mav.setViewName("form");
		return mav; 
	}
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		log.info(s.getcStudent()+"");
		try {
			if(s.getcStudent() == 1) {
				log.info("Agrego un nuevo usuario. Codigo:");
				//Agrego el nuevo usuario, el 1 representa que es una nueva instancia
				studentDao.save(s, 1);	
			}
			else {
				log.info("Actualizo el usuario");
				studentDao.save(s,0);
			}
		}catch(Exception e){
			log.info("Error:"+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
		
	}
	
	//Controlador que implementa Spring Data
	@RequestMapping(value = "/searchBy",method = RequestMethod.POST)
	public ModelAndView searchBy(@RequestParam(value = "name") String name,@RequestParam(value="age") Integer age) {
		ModelAndView mav = new ModelAndView();
		//Busco por nombre
		List<Student> studentsNameList = studentRepo.findBySName(name);
		//Busco por edad
		List<Student> studentsAgeList = studentRepo.findBySAge(age);
		mav.addObject("studentsname",studentsNameList);
		mav.addObject("studentsage",studentsAgeList);
		mav.setViewName("find");
		return mav; 
	}
	

}
