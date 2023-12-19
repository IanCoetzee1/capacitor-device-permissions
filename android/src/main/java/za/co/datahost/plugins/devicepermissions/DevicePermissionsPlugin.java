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

    private JSONObject supportedPermissions;
    private String OSIdent;
    private PermissionsHelperClass PermissionsHelpers = new PermissionsHelperClass();

    @Override
    public void load() {
      PermissionsHelpers.setContext(getContext());
      this.supportedPermissions = PermissionsHelpers.readJSONFile(R.raw.supportedpermissions);
      if (PermissionsHelpers.hasGMS()) {
          this.OSIdent = "androidGMS";
      } else if (PermissionsHelpers.hasHMS()) {
          this.OSIdent = "androidHMS";
      } else {
          this.OSIdent = "none";
          throw new RuntimeException("Device has to support either Google Mobile Services or Huawei Mobile Services");
      }
      PermissionsHelpers.setOSIdent(this.OSIdent);
      PermissionsHelpers.setDevicePermissionsJSON(this.supportedPermissions);
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        Log.i("IAN/DEV", "hasGMS " + PermissionsHelpers.hasGMS());
        Log.i("IAN/DEV", "hasHMS " + PermissionsHelpers.hasHMS());
        ret.put("value", "Hello");
        call.resolve(ret);
    }

    @PluginMethod
    public void isPermissionConfigured(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", "Hello");
        call.resolve(ret);
    }

    @PluginMethod
    public void hasGMS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("return", PermissionsHelpers.hasGMS());
        call.resolve(ret);
    }

    @PluginMethod
    public void hasHMS(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("return", PermissionsHelpers.hasHMS());
        call.resolve(ret);
    }
}
