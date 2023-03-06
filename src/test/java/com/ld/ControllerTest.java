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

}
