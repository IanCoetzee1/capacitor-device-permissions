package za.co.datahost.plugins.devicepermissions;

import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.content.Context;
import org.json.JSONObject;
import java.io.InputStream;

@CapacitorPlugin(name = "DevicePermissions")
public class DevicePermissionsPlugin extends Plugin {

    private JSONObject supportedPermissions;
    private DevicePermissions implementation = new DevicePermissions();
    private PermissionsHelperClass PermissionsHelpers = new PermissionsHelperClass();
    @Override
    public void load() {
        this.supportedPermissions = PermissionsHelpers.readJSONFile(R.raw.supportedpermissions, getContext());
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void isPermissionConfigured(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
