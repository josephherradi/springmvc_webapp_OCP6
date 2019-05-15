package springmvc.webapp.OCP6.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.webapp.OCP6.entity.Spot;
import springmvc.webapp.OCP6.entity.Voie;


@Repository
public class VoieDAOImpl implements VoieDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Voie> getVoies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveVoie(Voie laVoie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spot getVoie(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVoie(int theId) {
		// TODO Auto-generated method stub
		
	}

	
}
