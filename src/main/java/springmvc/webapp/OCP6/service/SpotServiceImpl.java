package springmvc.webapp.OCP6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.SpotDAO;
import springmvc.webapp.OCP6.entity.Spot;

@Service
public class SpotServiceImpl implements SpotService {
	@Autowired
	private SpotDAO spotDAO;
	
	@Override
	@Transactional
	public List<Spot> getSpots(){
		return spotDAO.getSpots();
	}
	
	@Override
	@Transactional
	public void saveSpot(Spot theSpot) {
		 spotDAO.saveSpot(theSpot);
	}
	
	@Override
	@Transactional
	public Spot getSpot(int theId) {
		return spotDAO.getSpot(theId);
	}
	
	@Override
	@Transactional
	public void deleteSpot(int theId) {
		spotDAO.deleteSpot(theId);
	}



	
	

}
