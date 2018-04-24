package idv.villebez.demo.page;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView("error500");	
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}
}
