package com.outerbrains.project.mapper;

import com.outerbrains.project.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectMapper {

    Project getById(@Param("id") Long id);

    void insert(Project project);

    void update(Project project);

    void delete(@Param("id") Long id);

}
