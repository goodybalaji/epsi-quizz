package quizz;

import java.awt.Font;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A cache of the dynamically loaded fonts found in the fonts directory.
 */
public class CustomFont {

  // Prepare a static "cache" mapping font names to Font objects.
  private static final String[] names = { "Hanged Letters.ttf" };

  private static final Map<String, Font> cache = new ConcurrentHashMap<String, Font>(names.length);
  static {
    for (String name : names) {
      cache.put(name, getFont(name));
    }
  }

  public static Font getFont(String name) {
    Font font = null;
    if (cache != null) {
      if ((font = cache.get(name)) != null) {
        return font;
      }
    }
    String fName = "Resources/" + name;
    try {
      InputStream is = CustomFont.class.getResourceAsStream(fName);
      font = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.err.println(fName + " not loaded.  Using serif font.");
      font = new Font("serif", Font.PLAIN, 24);
    }
    return font;
  }
}