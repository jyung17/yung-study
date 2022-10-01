package com.fastcampus.ch2;

import java.io.FileNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
  
  @ExceptionHandler(Exception.class)
  public String catcher(Exception ex, Model model) {
    System.out.println("catcher() in ExepctionController");
    System.out.println("model="+model);
    model.addAttribute("ex", ex);
    return "error";
  }
  
  @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
  public String cathcer2(Exception ex, Model model) {
    model.addAttribute("ex", ex);
    return "error";
  }
  
//  @RequestMapping("/ex")
//  public String main() throws Exception {
//      throw new Exception("예외가 발생했습니다.");
//  }
  
  @RequestMapping("/ex2")
  public String main2() throws Exception {
    throw new Exception("예외가 발생했습니다.");
  }
  
  @RequestMapping("/ex3")
  public String main3() throws NullPointerException {
    throw new NullPointerException("예외가 발생했습니다.");
  }
  
  @RequestMapping("/ex4")
  public String main4() throws FileNotFoundException {
    throw new FileNotFoundException("예외가 발생했습니다.");
  }
}
