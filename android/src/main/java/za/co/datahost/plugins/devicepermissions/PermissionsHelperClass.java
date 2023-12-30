package za.co.datahost.plugins.devicepermissions;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;

public class PermissionsHelperClass {

    private Context context;
    private String OSIdent;
    private Gson permissionsGSON;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOSIdent(String OSIdent) {
        this.OSIdent = OSIdent;
    }

    public void setDevicePermissionsGson(JSONObject allPermissions) {

        try {
            JSONObject permissionsJSON;
            JSONObject alias;
            if (allPermissions.has(this.OSIdent) && allPermissions.getJSONObject(this.OSIdent).has("alias")) {
                alias = allPermissions.getJSONObject(this.OSIdent);
                permissionsJSON = alias.getJSONObject("alias");
                //permissionsGSON.fromJson(permissionsJSON, String);
                Log.i("Ian/Dev", "JSON: " + permissionsJSON);
            } else {
                Log.e("Plugin: capacitor-device-permissions","Malformed JSON file (supported_permissions.json) class member '" + this.OSIdent + "' does not exist or the member does not have an 'alias' sub-member");
                throw new RuntimeException("Plugin: capacitor-device-permissions - Malformed JSON file (supported_permissions.json).");
            }
        } catch (JSONException ex) {
            Log.e("Plugin: capacitor-device-permissions","JSON does not contain a member named " + this.OSIdent);
            ex.printStackTrace();
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
            String json = new String(buffer, StandardCharsets.UTF_8);
            return new JSONObject(json);
        } catch (Exception ex) {
            Log.e("Plugin: capacitor-device-permissions","Could not read valid JSON from configuration");
            ex.printStackTrace();
            return null;
        }
    }
}
