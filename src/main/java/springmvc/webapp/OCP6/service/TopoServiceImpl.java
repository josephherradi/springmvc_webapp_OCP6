package springmvc.webapp.OCP6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.webapp.OCP6.dao.TopoDAO;
import springmvc.webapp.OCP6.entity.Topo;

@Service
public class TopoServiceImpl implements TopoService{
	@Autowired
	private TopoDAO topoDAO;

	@Override
	@Transactional
	public List<Topo> getUserTopos(String userId) {
		return topoDAO.getUserTopos(userId);
	}

	@Override
	@Transactional
	public void saveOrUpdateTopo(Topo leTopo, String userId) {
		topoDAO.saveOrUpdateTopo(leTopo, userId);
	}

	@Override
	@Transactional
	public Topo getTopo(int topoId) {
		return topoDAO.getTopo(topoId);
	}

	@Override
	@Transactional
	public void deleteTopo(int topoId) {
		topoDAO.deleteTopo(topoId);
	}
	@Override
	@Transactional
	public List<Topo> getTopos(String userId) {
		return topoDAO.getTopos(userId);
	}

}
