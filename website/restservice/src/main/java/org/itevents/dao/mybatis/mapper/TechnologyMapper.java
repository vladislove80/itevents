package org.itevents.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.itevents.dao.TechnologyDao;
import org.itevents.model.Technology;

import java.util.List;

/**
 * Created by vaa25 on 17.07.2015.
 */
public interface TechnologyMapper extends TechnologyDao {

    @ResultType(Technology.class)
    @Select("SELECT * FROM technology WHERE id = #{id}")
    Technology getTechnology(int id);

    @ResultType(Technology.class)
    @Select("SELECT * FROM technology ORDER BY name")
    List<Technology> getAllTechnologies();

    @ResultType(Technology.class)
    @Select({"<script>",
            "SELECT * FROM technology WHERE name IN ",
            "<foreach item='name' index='index' collection='names' open='(' separator=',' close=')'>",
            "   #{name}",
            "</foreach>",
            " ORDER BY name",
            "</script>"})
    List<Technology> getTechnologiesByNames(@Param("names") String[] names);

    @ResultType(Technology.class)
    @Select("SELECT * FROM technology t JOIN event_technology et ON t.id=et.technology_id AND et.event_id = #{eventId}" +
            " ORDER BY name")
    List<Technology> getTechnologiesByEventId(int eventId);

    @Insert("INSERT INTO technology(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true)
    void addTechnology(Technology technology);


    @Update("UPDATE technology SET name=#{name} WHERE id =#{id}")
    void updateTechnology(Technology technology);

    @Delete("DELETE FROM technology WHERE id =#{id}")
    void removeTechnology(Technology technology);

}
