package idv.villebez.demo.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseRest {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleError(HttpServletRequest req, Exception ex) {
		Map<String, String> map = new HashMap<String, String>();	
		map.put("exception", ex.getMessage());
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
