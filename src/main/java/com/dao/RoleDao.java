package com.dao;

import com.model.Role;

public interface RoleDao   {

    Role getByName(String role);

}