package org.itevents.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.itevents.model.Role;

import java.util.List;

/**
 * Created by vaa25 on 17.07.2015.
 */
public interface RoleMapper {

    @Select("SELECT * FROM roles WHERE id = #{id}")
    Role getRole(int id);

    @Select("SELECT * FROM roles")
    List<Role> getAllRoles();

    @Insert("INSERT INTO roles (name) VALUES(#{name})")
    @Options(useGeneratedKeys = true)
    void addRole(Role role);

    @Delete("DELETE FROM roles WHERE id =#{id}")
    void removeRole(Role role);
}
