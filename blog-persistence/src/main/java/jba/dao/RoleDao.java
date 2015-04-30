package jba.dao;

import jba.model.Role;

public interface RoleDao {
    public void save(Role role);

    public Role findByName(String role);
}
