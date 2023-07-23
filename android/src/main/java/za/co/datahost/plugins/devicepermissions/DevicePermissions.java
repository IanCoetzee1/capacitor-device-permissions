package za.co.datahost.plugins.devicepermissions;

import android.util.Log;

public class DevicePermissions {

    public String echo(String value) {
        //Log.i("Echo", value);
        Log.i("Echo", "I added this" + value);
        return value;
    }

    public String isPermissionConfigured() {
      return "Does not work";
    }
}
