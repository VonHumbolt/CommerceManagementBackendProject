package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý kaydedildi. " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý silindi!");
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi!");
		
	}

	@Override
	public User Get(String email) {
		System.out.println("Kullanýcý getirildi!");
		return null;
	}

	@Override
	public List<User> GetAll() {
		System.out.println("Tüm kullanýcýlar listelendi!");
		return null;
	}

}
