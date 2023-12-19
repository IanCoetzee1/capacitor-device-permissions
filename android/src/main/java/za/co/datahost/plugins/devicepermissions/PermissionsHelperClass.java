package za.co.datahost.plugins.devicepermissions;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import android.content.Context;

public class PermissionsHelperClass {

  private Context context;
  private String OSIdent;
  private JSONObject PermissionsJSON;

  public void setContext(Context context) {
    this.context = context;
  }

  public void setOSIdent(String OSIdent) {
    this.OSIdent = OSIdent;
  }

  public void setDevicePermissionsJSON(JSONObject allPermisions) {
    try {
      this.PermissionsJSON = allPermisions.getJSONObject(this.OSIdent);
    } catch (JSONException e) {
      throw new RuntimeException("JSON does not contain a member named " + this.OSIdent);
    }
  }

  public boolean hasGMS() {
    Context context = this.context;
    GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
    int resultCode = apiAvailability.isGooglePlayServicesAvailable(context);
    return resultCode == com.google.android.gms.common.ConnectionResult.SUCCESS;
  }
  public boolean hasHMS() {
    Context context = this.context;
    HuaweiApiAvailability apiAvailability = HuaweiApiAvailability.getInstance();
    int resultCode = apiAvailability.isHuaweiMobileServicesAvailable(context);
    return resultCode == com.huawei.hms.api.ConnectionResult.SUCCESS;
  }

  public JSONObject readJSONFile(int resourceId) {
    try {
      Context context = this.context;
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
