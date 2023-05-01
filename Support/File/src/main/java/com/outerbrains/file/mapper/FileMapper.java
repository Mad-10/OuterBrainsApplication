package com.outerbrains.file.mapper;

import com.outerbrains.file.entity.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO file(name, file_name, file_type, file_size, description, create_time, update_time) " +
            "VALUES(#{name}, #{fileName}, #{fileType}, #{fileSize}, #{description}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(File file);

    @Select("SELECT * FROM file WHERE id=#{id}")
    File getById(Long id);

    @Select("SELECT * FROM file WHERE name=#{name}")
    File getByName(String name);

    @Select("SELECT * FROM file")
    List<File> getAll();

    @Update("UPDATE file SET name=#{name}, file_name=#{fileName}, file_type=#{fileType}, file_size=#{fileSize}, " +
            "description=#{description}, update_time=#{updateTime} WHERE id=#{id}")
    int update(File file);

    @Delete("DELETE FROM file WHERE id=#{id}")
    int deleteById(Long id);
}
