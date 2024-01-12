package com.david.dto.board;

public class BoardUpdateRequestDto {
    private String title;
    private String content;

    // 기본 생성자
    public BoardUpdateRequestDto() {
    }

    // 매개변수가 있는 생성자
    public BoardUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter와 Setter 메소드
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString 메소드 (선택적)
    @Override
    public String toString() {
        return "BoardUpdateRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}