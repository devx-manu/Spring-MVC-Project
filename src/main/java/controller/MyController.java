package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.StudentDao;
import dto.Student;

@Controller
public class MyController {

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute Student student)
	{
		StudentDao studentDto=new StudentDao();
		
		studentDto.insert(student);
		System.out.println(student);
		return "Data Inserted";
	}
	
	@RequestMapping("/fetch")
//	public ModelAndView fetchById(@RequestParam("id") int id) this is URL rewriting
	public Object fetchById(@ModelAttribute Student std)
	{
		
//		System.out.println(id);
		
		StudentDao studentDao=new StudentDao();
		for(int i=0;i<=std.getId();i++)
		{
			if(i==std.getId()) {
		Student student=studentDao.fetchById(std.getId());
		
		ModelAndView modelAndView=new ModelAndView("View.jsp");
		modelAndView.addObject("data",student);
		return modelAndView;
			}
		}
		return null;
	}
	
//	@RequestMapping("/delete/{id}") 
//	public String delete(@PathVariable("id") int id) " path variable to get id ! "
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(@ModelAttribute Student std)
	{
		StudentDao studentDao=new StudentDao();
		 studentDao.deleteById(std.getId());
		

		List<Student> list=studentDao.fetchAll();
		
		ModelAndView modelAndView=new ModelAndView("FetchAll.jsp");
		modelAndView.addObject("data",list);
		return modelAndView;
	}
	
	
	
	@RequestMapping("/fall")
	public ModelAndView fetchAll() {
		StudentDao studentDao=new StudentDao();
		List<Student> list=studentDao.fetchAll();
		ModelAndView modelAndView=new ModelAndView("FetchAll.jsp");
		modelAndView.addObject("data",list);
		return modelAndView;
		
	}
	
	@RequestMapping("/dall")
	@ResponseBody
	public String deleteAll() {
		StudentDao studentDao=new StudentDao();
		return	studentDao.deletAll();
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ModelAndView update(@ModelAttribute Student student)
	{
		StudentDao studentDao=new StudentDao();
		 studentDao.update(student);
		 List<Student> list=studentDao.fetchAll();
		 ModelAndView modelAndView=new ModelAndView("FetchAll.jsp");
		 modelAndView.addObject("data",list);
		 return modelAndView;
	}
}
