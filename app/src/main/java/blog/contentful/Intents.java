package blog.contentful;

public class Intents {
  private Intents() {
    throw new AssertionError();
  }

  private static final String PACKAGE_NAME = App.get().getPackageName();

  public static final String ACTION_CHANGE_SPACE = PACKAGE_NAME + ".ACTION_CHANGE_SPACE";

  public static final String EXTRA_BUSINESS = "EXTRA_BUSINESS";
}
