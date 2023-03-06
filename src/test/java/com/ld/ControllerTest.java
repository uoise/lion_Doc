package com.ld;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ControllerTest {

    @Test
    @DisplayName("step 1: init")
    public void t1() {
        String res = TestRunner.run("");
        assertThat(res)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("step 1: err")
    public void t2() {
        String res = TestRunner.run("종료1");
        assertThat(res)
                .contains("올바르지 않은 명령입니다.");
    }

    @Test
    @DisplayName("step 3: create() return id")
    public void t3() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇
                """);
        assertThat(res)
                .contains("명언 : ")
                .contains("작가 : ")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("step 4: create() auto increment")
    public void t5() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                등록
                안녕 안녕!
                안녕로봇                
                등록
                안녕 안녕?
                안녕로봇
                종료
                """);
        assertThat(res)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("3번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("step 5: get list")
    public void t6() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                등록
                안녕 안녕!
                안녕로봇                
                등록
                안녕 안녕?
                안녕로봇
                목록
                """);
        assertThat(res)
                .contains("3 / 안녕 안녕? / 안녕로봇")
                .contains("2 / 안녕 안녕! / 안녕로봇")
                .contains("1 / 안녕 안녕 / 안녕로봇");
    }

    @Test
    @DisplayName("step 6: remove")
    public void t7() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                등록
                안녕 안녕!
                안녕로봇                
                등록
                안녕 안녕?
                안녕로봇
                삭제?id=1 
                """);
        assertThat(res)
                .contains("1번 명언이 삭제되었습니다.");
    }

    @Test
    @DisplayName("step 7: exist")
    public void t8() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                삭제?id=2 
                """);
        assertThat(res)
                .contains("2번 명언은 존재하지 않습니다.");
    }

    @Test
    @DisplayName("step 8: update")
    public void t9() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                수정?id=1
                아아아안녕
                안녕고물
                목록
                """);
        assertThat(res)
                .contains("1 / 아아아안녕 / 안녕고물");
    }

}
