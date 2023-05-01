package com.outerbrains.task.entity;

import com.outerbrains.base.entity.OuterBrainsObject;
import com.outerbrains.file.entity.File;
import com.outerbrains.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Task extends OuterBrainsObject {
    private Date deadline;
    private TaskStatus status;
    private List<User> executors;
    private User supervisor;
    private User creator;
    private List<User> auditors;
    private List<File> supportFiles;
    private List<File> resultFiles;

    public Task() {
        super();
    }

    public enum TaskStatus {
        NOT_STARTED,//未开始
        IN_PROGRESS,//进行中
        COMPLETED,//已完成
        CANCELLED//已取消
    }
}
