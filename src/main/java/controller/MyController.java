package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/i")
	@ResponseBody
	public String insert()
	{
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
