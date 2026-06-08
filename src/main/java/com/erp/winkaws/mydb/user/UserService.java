package com.erp.winkaws.mydb.user;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.winkaws.mydb.authority.Authority;
import com.erp.winkaws.mydb.authority.Permission;
import com.erp.winkaws.mydb.role.Role;
import com.erp.winkaws.mydb.role.RoleRepository;
import com.erp.winkaws.mydb.role.dto.RoleCreateDTO;
import com.erp.winkaws.mydb.role.dto.RoleUpdateDTO;
import com.erp.winkaws.mydb.user.dto.UserCreateDTO;
import com.erp.winkaws.mydb.user.dto.UserDTO;
import com.erp.winkaws.mydb.user.dto.UserUpdateDTO;
import com.erp.winkaws.mydb.user.mapper.UserMapper;
import com.erp.winkaws.mydb.usersettings.UserSettings;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsCreateDTO;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsUpdateDTO;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void save(UserCreateDTO dto) {
		if (dto == null)
			return;
		User user = userMapper.toEntity(dto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		setSettings(dto, user);
		setRole(dto, user);
		setPermissions(dto, user);
		userRepository.save(user);
	}
	
	@Transactional
	public void update(UserUpdateDTO dto) {
	    if (dto == null) return;
	    User user = userRepository.findByUsername(dto.username());
	    if (user == null) return;
	    if (dto.password() != null && !dto.password().isBlank()) {
	        user.setPassword(passwordEncoder.encode(dto.password()));
	    }
	    if (dto.roles() != null && !dto.roles().isEmpty()) {
	        Set<Role> roles = new HashSet<>();
	        for (RoleUpdateDTO roleDTO : dto.roles()) {
	            Role role = roleRepository.findByName(roleDTO.name())
	                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleDTO.name()));
	            roles.add(role);
	        }
	        user.setRoles(roles);
	    }
	    if (dto.permissions() != null && !dto.permissions().isEmpty()) {
	        Set<Authority> authoritiesSet = new HashSet<>();
	        for (Permission permission : dto.permissions()) {
	            Authority auth = new Authority();
	            auth.setPermission(permission);
	            auth.setUser(user);
	            authoritiesSet.add(auth);
	        }
	        user.setAuthorities(authoritiesSet);
	    }
	    if (dto.settings() != null) {
	        UserSettings settings = user.getSettings();
	        if (settings == null) {
	            settings = new UserSettings();
	            settings.setUser(user);
	        }
	        UserSettingsUpdateDTO s = dto.settings();
	        settings.setSubeId(s.subeId());
	        settings.setKasaId(s.kasaId());
	        settings.setWinkaKullaniciId(s.winkaKullaniciId());
	        settings.setCariOzelKod3Id(s.cariOzelKod3Id());
	        settings.setIskontoOrani(s.iskontoOrani());
	        settings.setSatisFaturasiDizayn(s.satisFaturasiDizayn());
	        settings.setSatisIadeFaturasiDizayn(s.satisIadeFaturasiDizayn());
	        settings.setAlisFaturasiDizayn(s.alisFaturasiDizayn());
	        settings.setAlisIadeFaturasiDizayn(s.alisIadeFaturasiDizayn());
	        settings.setAlinanSiparisDizayn(s.alinanSiparisDizayn());
	        settings.setVerilenSiparisDizayn(s.verilenSiparisDizayn());
	        settings.setDepoTransferDizayn(s.depoTransferDizayn());
	        settings.setStokCikisBelgesiDizayn(s.stokCikisBelgesiDizayn());
	        settings.setStokGirisBelgesiDizayn(s.stokGirisBelgesiDizayn());
	        settings.setCariCikisDizayn(s.cariCikisDizayn());
	        settings.setCariGirisDizayn(s.cariGirisDizayn());
	        settings.setYaziciAdi(s.yaziciAdi());
	        user.setSettings(settings);
	    }
	    userRepository.save(user);
	}

	@Transactional
	public void createAdminUser() {
		if (userRepository.existsByUsername("admin"))
			return;
		Role role = roleRepository.findByName("ROLE_ADMIN")
				.orElseThrow(() -> new RuntimeException("ADMIN not found"));
		User user = new User();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("meganet.123"));
		user.getRoles().add(role);
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public Page<UserDTO> getUsers(Pageable pageable) {
		return userRepository.findAll(pageable).map(userMapper::toDTO);
	}

	public Optional<User> findByIdWithRoles(Integer id) {
		return userRepository.findByIdWithRoles(id);
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	private void setRole(UserCreateDTO dto, User user) {
		if (dto.roles() == null || dto.roles().isEmpty())
			return;
		Set<Role> roles = new HashSet<Role>();
		for (RoleCreateDTO roleDTO : dto.roles()) {
			Role role = roleRepository.findByName(roleDTO.name())
					.orElseThrow(() -> new RuntimeException("Role not found" + roleDTO.name()));
			roles.add(role);
		}
		user.setRoles(roles);
	}

	private void setSettings(UserCreateDTO dto, User user) {
		if (dto.settings() == null)
			return;
		UserSettingsCreateDTO settingsDTO = dto.settings();
		UserSettings settings = new UserSettings();
		settings.setId(settingsDTO.id());
		settings.setSubeId(settingsDTO.subeId());
		settings.setKasaId(settingsDTO.kasaId());
		settings.setWinkaKullaniciId(settingsDTO.winkaKullaniciId());
		settings.setCariOzelKod3Id(settingsDTO.cariOzelKod3Id());
		settings.setIskontoOrani(settingsDTO.iskontoOrani());
		settings.setSatisFaturasiDizayn(settingsDTO.satisFaturasiDizayn());
		settings.setSatisIadeFaturasiDizayn(settingsDTO.satisIadeFaturasiDizayn());
		settings.setAlisFaturasiDizayn(settingsDTO.alisFaturasiDizayn());
		settings.setAlisIadeFaturasiDizayn(settingsDTO.alisIadeFaturasiDizayn());
		settings.setAlinanSiparisDizayn(settingsDTO.alinanSiparisDizayn());
		settings.setVerilenSiparisDizayn(settingsDTO.verilenSiparisDizayn());
		settings.setDepoTransferDizayn(settingsDTO.depoTransferDizayn());
		settings.setStokCikisBelgesiDizayn(settingsDTO.stokCikisBelgesiDizayn());
		settings.setStokGirisBelgesiDizayn(settingsDTO.stokGirisBelgesiDizayn());
		settings.setCariCikisDizayn(settingsDTO.cariCikisDizayn());
		settings.setCariGirisDizayn(settingsDTO.cariGirisDizayn());
		settings.setYaziciAdi(settingsDTO.yaziciAdi());
		settings.setUser(user);
		user.setSettings(settings);
	}

	private void setPermissions(UserCreateDTO dto, User user) {
		if (dto.permissions() == null || dto.permissions().isEmpty())
			return;
		Set<Authority> authoritiesSet = new HashSet<>();
		for (Permission permission : dto.permissions()) {
			Authority auth = new Authority();
			auth.setPermission(permission);
			auth.setUser(user);
			authoritiesSet.add(auth);
		}
		user.setAuthorities(authoritiesSet);
	}

}
