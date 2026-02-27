package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/d")
	@ResponseBody
	public String delete()
	{
		return "Data Deleted";
	}
	
	@RequestMapping("/u")
	@ResponseBody
	public String update()
	{
		return "Data Updated";
	}
	
	@RequestMapping("/f")
	@ResponseBody
	public String fetch()
	{
		return "Data Fetched";
	}
}
