package cl.everis.test.transbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.everis.test.transbank.model.UserPrincipal;
import cl.everis.test.transbank.model.Users;
import cl.everis.test.transbank.repository.UsersRepository;

@Service
public class UsersDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = usersRepository.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

}
