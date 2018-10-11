package fr.ousmane.spring.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.ousmane.spring.ui.mapping.MappingUser;
import fr.ousmane.spring.ui.model.Adresse;
import fr.ousmane.spring.ui.model.User;

@Controller
@RequestMapping(MappingUser.MAPPING_USER)
public class UserComtroller {
	
	private static Map<Integer, User> mapDao = new HashMap<Integer, User>();
	
	private static Integer cle = 1;
	
	@RequestMapping(value=MappingUser.MAPPING_INIT_DAO, method=RequestMethod.GET)
	public @ResponseBody User initDao(){
		User user = new User();
		user.setId(cle);
		user.setLastname("DIOP");
		user.setFirstname("Ousmane");
		user.setAge(20);
		
		Adresse adresse = new Adresse();
		adresse.setNomRue("1 ru du bocage");
		adresse.setCodePostal(93450);
		adresse.setCommune("L'ile Saint Denis");
		user.setAdresse(adresse);
		
		mapDao.put(cle, user);
		
		cle++;
		
		return user;
	}
	
	
	@RequestMapping(value=MappingUser.MAPPING_LIST_USER, method=RequestMethod.GET)
	public @ResponseBody List<User> findAllUser(){
		List<User> listUser = new ArrayList<User>();
		
		for(Integer key : mapDao.keySet()) {
			listUser.add(mapDao.get(key));
		}
		
		return listUser;
	}
	
	@RequestMapping(value=MappingUser.MAPPING_ADD_USER, method=RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user) {
		if(user == null) {
			return null;
		}
		if(user.getId() == null) {
			user.setId(cle);
			mapDao.put(cle, user);
			cle++;
			return user;
		}else if(mapDao.get(user.getId()) != null){
			mapDao.put(user.getId(), user);
			return user;
		}
		
		return null;
	}
	
	@RequestMapping(value=MappingUser.MAPPING_FIND_USER, method=RequestMethod.GET)
	public @ResponseBody User findUser(@PathVariable Integer id) {
				
		for(Integer key : mapDao.keySet()) {
			if(key == id) {
				return mapDao.get(key);
			}
		}
		
		return null;
	}

}
