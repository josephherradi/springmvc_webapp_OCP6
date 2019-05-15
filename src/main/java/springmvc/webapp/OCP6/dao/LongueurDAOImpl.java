package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Longueur;

@Repository
public class LongueurDAOImpl implements LongueurDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Longueur> getLongueurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLongueur(Longueur laLongueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Longueur getLongueur(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLongueur(int theId) {
		// TODO Auto-generated method stub
		
	}

}
