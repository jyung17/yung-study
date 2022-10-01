### Ch.03-01 Spring DI 흉내내기(1)
1. 변경에 유리한 코드(1) - 다형성, factory method
```java
  static Object getObject(String key) throws Exception {
    // config.txt를 읽어서 Properties에 저장
    Properties p = new Properties();
    p.load(new FileReader("config.txt"));
    
    // 클래스 객체(설계도)를 얻어서
    Class clazz = Class.forName(p.getProperty(key));
    
    return clazz.newInstance(); // 객체를 생성해서 반환
  }
```

`Properties(String, String)` 한쌍으로 데이터를 저장한다.
`p.load(new FileReader("config.txt"));` 메소드가 파일에서 데이터를 읽어오거나 저장할때 편리해서 사용하며, Map에 저장한다.

```text
car=com.fastcampus.ch3.diCopy1.Truck
```

|key|Value|
|-|-|
|car|com.fastcampus.ch3.diCopy1.Truck|

장점 : config.txt파일만 변경하면 되고 코드는 변경하지 않아도 된다.
코드가 변경되면 테스트가 필수적이다.
프로그램이 변경되지 않는다.
컴파일을 다시하지 않아도 된다.


OOP 분리
1. 변하는것, 변하지 않는것
2. 관심사의 분리
3. 중복코드 분리