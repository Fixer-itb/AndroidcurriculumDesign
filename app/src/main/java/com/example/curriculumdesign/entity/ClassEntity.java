package com.example.curriculumdesign.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

public class ClassEntity implements Serializable {
    private long id;
    /**
     * 创建人id
     */
    private Long createId;
    /**
     * 课程名
     */
    private String className;

    /**
     * 课程内容
     */
    private String classContent;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

    public ClassEntity(String className, String classContent) {
        this.className = className;
        this.classContent = classContent;
    }

    public ClassEntity(long id, Long createId, String className, String classContent, LocalDateTime gmtCreated, LocalDateTime gmtModified) {
        this.id = id;
        this.createId = createId;
        this.className = className;
        this.classContent = classContent;
        this.gmtCreated = gmtCreated;
        this.gmtModified = gmtModified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
