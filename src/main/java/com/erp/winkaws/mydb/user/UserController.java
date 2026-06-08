package com.erp.winkaws.mydb.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.mydb.user.dto.UserCreateDTO;
import com.erp.winkaws.mydb.user.dto.UserDTO;
import com.erp.winkaws.mydb.user.dto.UserUpdateDTO;
import com.erp.winkaws.shared.GenericMessage;

@RequestMapping("/api/1.0.1/users")
@RestController
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<GenericMessage> save(@RequestBody UserCreateDTO user) {
		userService.save(user);
		return ResponseEntity.status(201).body(new GenericMessage("User created!"));
	}
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> getUsers(Pageable pageable) {
		return ResponseEntity.status(200).body(userService.getUsers(pageable));
	}
	
	@PutMapping
	public ResponseEntity<GenericMessage> update(@RequestBody UserUpdateDTO dto) {
		userService.update(dto);
		return ResponseEntity.status(200).body(new GenericMessage("User updated."));
	}
	
}
