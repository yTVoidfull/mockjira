package commons;

public class InputAssertion {

  public static void assertNotNull(Object o, String message) {
      if(o == null){
        throw new IllegalStateException(message);
      }
  }

  public static void assertStringMatchesPattern(String string, String pattern, String message) {
      if(!string.matches(pattern)){
        throw new IllegalStateException(message);
      }
  }
}
