package za.co.datahost.plugins.devicepermissions;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.api.HuaweiApiAvailability;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;

public class PermissionsHelperClass {
    private Context context;
    private String OSIdent;
    private JsonElement permissionsJsonAliasElement;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOSIdent(String OSIdent) {
        this.OSIdent = OSIdent;
    }

    public void setDevicePermissionsGson(JSONObject allPermissions) {
        JSONObject alias;
        try {

            if (allPermissions.has(this.OSIdent) && allPermissions.getJSONObject(this.OSIdent).has("alias")) {
                alias = allPermissions.getJSONObject(this.OSIdent);
                Gson gson = new Gson();
                this.permissionsJsonAliasElement = gson.fromJson(alias.getJSONObject("alias").toString() , JsonElement.class);
                if (this.permissionsJsonAliasElement.isJsonObject()) {
                    JsonObject jsonObject = this.permissionsJsonAliasElement.getAsJsonObject();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        String key = entry.getKey();
                        JsonObject MemberEntries = entry.getValue().getAsJsonObject();

                        Integer minSDK = MemberEntries.get("minSDK").getAsInt();
                        Integer maxSDK = MemberEntries.get("maxSDK").getAsInt();
                        JsonArray permissionsArray = MemberEntries.get("permissionsArray").getAsJsonArray();
                        Log.i("Ian/Dev", "Key: " + key + " Value: " + permissionsArray );
                        for (int i = 0; i < permissionsArray.size(); i++) {
                            String permission = permissionsArray.get(i).getAsString();
                            Log.i("Ian/Dev", "   Count: (" + i + ") " + permission);
                        }
                    }
                } else {
                    Log.e("Plugin: capacitor-device-permissions","Malformed JSON file (supported_permissions.json) class member '" + this.OSIdent + "' does not exist or the alias sub-member is not a valid JSON Object");
                    throw new RuntimeException("Plugin: capacitor-device-permissions - Malformed JSON file (supported_permissions.json).");
                }
                Log.i("Ian/Dev", "JSON: " + this.permissionsJsonAliasElement.toString());
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
