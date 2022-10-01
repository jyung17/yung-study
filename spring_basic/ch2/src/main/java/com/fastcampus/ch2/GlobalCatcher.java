package com.fastcampus.ch2;

import java.io.FileNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") // 지정된 패키지에서 발생한 예외만 처리
public class GlobalCatcher {
  @ExceptionHandler(Exception.class)
  public String catcher(Exception e, Model model) {
    model.addAttribute("ex", e);
    return "error";
  }
  
  @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
  public String cathcer2(Exception e, Model model) {
    model.addAttribute("ex", e);
    return "error";
  }
}
