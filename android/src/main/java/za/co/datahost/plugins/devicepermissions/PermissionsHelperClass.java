package za.co.datahost.plugins.devicepermissions;

import android.content.Context;
import org.json.JSONObject;
import java.io.InputStream;

public class PermissionsHelperClass {
  public JSONObject readJSONFile(int resourceId, Context ctx) {
    try {
      Context context = ctx;
      InputStream is = context.getResources().openRawResource(resourceId);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      String json = new String(buffer, "UTF-8");
      return new JSONObject(json);
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
