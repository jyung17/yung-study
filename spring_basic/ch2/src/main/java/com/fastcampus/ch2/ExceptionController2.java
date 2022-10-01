package com.fastcampus.ch2;

import java.io.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
class MyExeption extends RuntimeException {
  MyExeption(String msg) {
    super(msg);
  }
  MyExeption() {
    this("");
  }
}

@Controller
public class ExceptionController2 {
  
  @RequestMapping("/ex5")
  public String main() throws Exception {
      throw new MyExeption("예외가 발생했습니다.");
  }
  
  @RequestMapping("/ex6")
  public String main2() throws Exception {
    throw new Exception("예외가 발생했습니다.");
  }
  
  @RequestMapping("/ex")
  public String main(Model m) throws Exception {
    m.addAttribute("msg", "message from ExceptionController.main()");
    try{
      throw new Exception("예외가 발생했습니다.");
    } catch(Exception e) {
      return "error";
    }
  }
}
