package za.co.datahost.plugins.devicepermissions;

import android.content.Context;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

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

  public boolean hasGMS(Context context) {
    GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
    int resultCode = apiAvailability.isGooglePlayServicesAvailable(context);
    return resultCode == com.google.android.gms.common.ConnectionResult.SUCCESS;
  }
  public boolean hasHMS(Context context) {
    HuaweiApiAvailability apiAvailability = HuaweiApiAvailability.getInstance();
    int resultCode = apiAvailability.isHuaweiMobileServicesAvailable(context);
    return resultCode == com.huawei.hms.api.ConnectionResult.SUCCESS;
  }
}
