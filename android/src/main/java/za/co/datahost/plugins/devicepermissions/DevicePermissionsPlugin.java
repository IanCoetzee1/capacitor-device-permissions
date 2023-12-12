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

    @Override
    public void load() {
        this.supportedPermissions = readJSONFile(R.raw.supportedpermissions);
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

    private JSONObject readJSONFile(int resourceId) {
        try {
            Context context = getContext();
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
