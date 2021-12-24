package com.example.curriculumdesign.entity;

public class pageResponse {
    @Override
    public String toString() {
        return "pageResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", page=" + page.toString() +
                '}';
    }

    private String message;
    private int code;
    private Page page;

    public pageResponse(String message, int code, Page page) {
        this.message = message;
        this.code = code;
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
