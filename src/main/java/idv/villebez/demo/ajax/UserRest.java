package idv.villebez.demo.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idv.villebez.demo.model.User;

@RestController
@RequestMapping("/ajax/users")
public class UserRest extends BaseRest {
	
	private Map<String, User> mockData = new HashMap<String, User>();
	
	public UserRest() {
		User user = new User(UUID.randomUUID().toString(), "Paul", 20);
		mockData.put(user.getId(), user);
		user = new User(UUID.randomUUID().toString(), "Allen", 30);
		mockData.put(user.getId(), user);
		user = new User(UUID.randomUUID().toString(), "Eric", 40);
		mockData.put(user.getId(), user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> list(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "offset", required = false) String offset) throws Exception {
		return new ArrayList<User>(mockData.values());
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
			throws Exception {
		String id = UUID.randomUUID().toString();
		user.setId(id);
		mockData.put(id, user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(HttpServletRequest request, HttpServletResponse response, @PathVariable String id)
			throws Exception {
		mockData.remove(id);
	}

}
