package tunehub.services;

import tunehub.entities.Users;


public interface UsersService 
{
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);
	
}
