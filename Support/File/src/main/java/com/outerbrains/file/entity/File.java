package com.outerbrains.file.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class File extends OuterBrainsObject {
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String description;

    public File() {
        super();
    }

}
