package openapi.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;

public class Exam0320 {

  public static void main(String[] args) {
    String jsonStr = "[{\"no\":101,\"name\":\"홍길동\"},{\"no\":102,\"name\":\"임꺽정\"},{\"no\":103,\"name\":\"안창호\"}]";
//    class MyTypeToken extends TypeToken<Collection<Member>> {
//      }
//    MyTypeToken typeToken = new MyTypeToken();
//    Type collectionType = typeToken.getType();
//    Collection<Member> list = new Gson().fromJson(jsonStr, collectionType);

//    Type collectionType = new TypeToken<Collection<Member>>(){}.getType();
//    Collection<Member> list = new Gson().fromJson(jsonStr, collectionType);

    Type collectionType = new TypeToken<Collection<Member>>(){}.getType();
    Collection<Member> list = new Gson().fromJson(jsonStr, collectionType);

    for (Member m : list) {
      System.out.println(m);
    }
  }

}
