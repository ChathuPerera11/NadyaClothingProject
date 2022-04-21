package com.nadyaclothing.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nadyaclothing.common.entity.*;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
