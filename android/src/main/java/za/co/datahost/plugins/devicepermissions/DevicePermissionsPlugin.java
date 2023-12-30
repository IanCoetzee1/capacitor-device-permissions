package za.co.datahost.plugins.devicepermissions;

import android.util.Log;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import org.json.JSONObject;

@CapacitorPlugin(name = "DevicePermissions")
public class DevicePermissionsPlugin extends Plugin {
    private String OSIdent;
    private PermissionsHelperClass PermissionsHelpers = new PermissionsHelperClass();

    @Override
    public void load() {
      JSONObject supportedPermissions;

      PermissionsHelpers.setContext(getContext());
      supportedPermissions = PermissionsHelpers.readJSONFile(R.raw.supported_permissions);
      if (PermissionsHelpers.hasGMS()) {
          this.OSIdent = "androidGMS";
      } else if (PermissionsHelpers.hasHMS()) {
          this.OSIdent = "androidHMS";
      } else {
          this.OSIdent = "none";
          throw new RuntimeException("Device has to support either Google Mobile Services or Huawei Mobile Services");
      }
      PermissionsHelpers.setOSIdent(this.OSIdent);
      PermissionsHelpers.setDevicePermissionsGson(supportedPermissions);
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
    public void getPermissionStatus(PluginCall call) {
        String permission = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("result", permission);
        call.resolve(ret);
    }

    @PluginMethod
    public void isAndroid(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", true);
        call.resolve(ret);
    }

    @PluginMethod
    public void isIOS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", false);
        call.resolve(ret);
    }

    @PluginMethod
    public void isWeb(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", false);
        call.resolve(ret);
    }
    @PluginMethod
    public void hasGMS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", PermissionsHelpers.hasGMS());
        call.resolve(ret);
    }

    @PluginMethod
    public void hasHMS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("result", PermissionsHelpers.hasHMS());
        call.resolve(ret);
    }
}
