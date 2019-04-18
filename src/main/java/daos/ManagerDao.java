package daos;

import java.util.List;

import beans.Manager;

public interface ManagerDao {

	List<Manager> getAllManagers();
	Manager getManagerById(int id);
	Manager updateManager(Manager manager);
}
