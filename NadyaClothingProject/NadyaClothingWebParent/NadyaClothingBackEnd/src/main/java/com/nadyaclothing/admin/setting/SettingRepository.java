package com.nadyaclothing.admin.setting;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nadyaclothing.common.entity.Setting;
import com.nadyaclothing.common.entity.SettingCategory;

public interface SettingRepository extends CrudRepository<Setting, String> {
	public List<Setting> findByCategory(SettingCategory category);
}
