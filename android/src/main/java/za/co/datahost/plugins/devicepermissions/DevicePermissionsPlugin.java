package za.co.datahost.plugins.devicepermissions;

import android.util.Log;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "DevicePermissions")
public class DevicePermissionsPlugin extends Plugin {
    private String OSIdent;
    private PermissionsHelperClass PermissionsHelpers = new PermissionsHelperClass();

    @Override
    public void load() {
      JSONObject supportedPermissions;

      PermissionsHelpers.SetContext(getContext());
      supportedPermissions = PermissionsHelpers.readJSONFile(R.raw.supported_permissions);
      if (PermissionsHelpers.HasGMS()) {
          this.OSIdent = "androidGMS";
      } else if (PermissionsHelpers.HasHMS()) {
          this.OSIdent = "androidHMS";
      } else {
          this.OSIdent = "none";
          throw new RuntimeException("Device has to support either Google Mobile Services or Huawei Mobile Services");
      }
      PermissionsHelpers.SetOSIdent(this.OSIdent);
      PermissionsHelpers.SetDevicePermissionsGson(supportedPermissions);
    }

//    Leaving this in place as an example
//    @PluginMethod
//    public void echo(PluginCall call) {
//        String value = call.getString("value");
//        JSObject ret = new JSObject();
//        Log.i("IAN/DEV", "hasGMS " + PermissionsHelpers.hasGMS());
//        Log.i("IAN/DEV", "hasHMS " + PermissionsHelpers.hasHMS());
//        ret.put("value", "Hello");
//        call.resolve(ret);
//    }

    @PluginMethod
    public void IsPermissionGranted(PluginCall call) {
        JSArray permissions = call.getArray("permissions");
        if (permissions != null && permissions.length() > 0) {
            for (int i = 0; i < permissions.length(); i++) {
                try {
                    String permission = permissions.getString(i);
                    //TODO: The below loops through the permissions and checks if they are defined. This can be done with a single call
                    //IsConfiguredInManifest can handle all the logic below.
                    JSONObject permissionParameters = PermissionsHelpers.getParametersFromSupportedPermissionsAlias(permission);
                    int minSDK = permissionParameters.has("minSDK") ? permissionParameters.getInt("minSDK") : 0;
                    Log.i("Ian/Dev:", i + " (" + permission + ") minSDK: " + minSDK + " - Details - " + permissionParameters);
                    //TODO: End of rethinking my logic
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        JSObject ret = new JSObject();
        ret.put("value", "This is a string");
        call.resolve(ret);
    }

    @PluginMethod
    public void IsAndroid(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", true);
        call.resolve(ret);
    }

    @PluginMethod
    public void IsIOS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", false);
        call.resolve(ret);
    }

    @PluginMethod
    public void IsWeb(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", false);
        call.resolve(ret);
    }

}
