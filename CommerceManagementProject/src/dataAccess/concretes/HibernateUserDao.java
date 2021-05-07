package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� kaydedildi. " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� silindi!");
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� g�ncellendi!");
		
	}

	@Override
	public User Get(String email) {
		System.out.println("Kullan�c� getirildi!");
		return null;
	}

	@Override
	public List<User> GetAll() {
		System.out.println("T�m kullan�c�lar listelendi!");
		return null;
	}

}
