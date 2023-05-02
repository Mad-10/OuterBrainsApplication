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
    private Date deadline;//截止时间
    private TaskStatus status;//任务状态
    private List<User> executors;//执行者
    private User supervisor;//监督者
    private User creator;//创建者
    private List<User> auditors;//审核者
    private List<File> supportFiles;//任务所需材料
    private List<File> resultFiles;//

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
