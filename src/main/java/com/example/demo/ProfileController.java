package com.example.demo;




import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

@Controller
@ResponseBody
public class ProfileController{
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView renderFirstPage(@RequestParam Map<String,Object> model,Model viewModel) {
		ModelAndView mav = new ModelAndView("/index");

		return mav;
	}
	private AmazonClient amazonClient;
	

	    @Autowired
	     ProfileController(AmazonClient amazonClient) {
	        this.amazonClient = amazonClient;
	    }
	    //HttpServletRequest request = null;

	    @PostMapping("/uploadFile")
		
	    public String uploadFile(@RequestPart(value = "file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
	    	
	    	//viewModel.addAttribute("member",this.amazonClient.uploadFile(file));
	    	//
	    	//if(request==null)
		    	//request.getSession().setAttribute("key","No ImageLink");
	    	//else
	    	request.getSession().setAttribute("key",this.amazonClient.uploadFile(file));
	    	return "Picture has been Succefully upload to "+ this.amazonClient.uploadFile(file);
	    	//return (String)request.getSession().getAttribute("key");
	    	
	    	
	    }
	    
	    
	    	
	    
	   
	   
}
