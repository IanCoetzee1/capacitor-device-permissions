package za.co.datahost.plugins.devicepermissions;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "DevicePermissions")
public class DevicePermissionsPlugin extends Plugin {

    private DevicePermissions implementation = new DevicePermissions();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        //Object permissionsAvailable = DevicePermissionsPlugin.supportedPermissions;
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
