package za.co.datahost.plugins.devicepermissions;

import android.util.Log;

import com.getcapacitor.JSObject;

public class DevicePermissions {

    public String echo(String value) {
        //Log.i("Echo", value);
        Log.i("IAN/DEV", "I added this: " + value);
        return value;
    }

    public String isPermissionConfigured() {
      return "Does not work";
    }
}
