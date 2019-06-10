package springmvc.webapp.OCP6.dao;

import java.util.List;

import springmvc.webapp.OCP6.entity.Topo;

public interface TopoDAO {
	public List<Topo> getTopos(String userId);
	public void saveOrUpdateTopo(Topo leTopo,String userId);
	public Topo getTopo(int topoId);
	public void deleteTopo(int topoId);

}
