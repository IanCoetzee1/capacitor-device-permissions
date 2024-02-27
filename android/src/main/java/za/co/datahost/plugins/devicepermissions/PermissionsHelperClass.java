package za.co.datahost.plugins.devicepermissions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import za.co.datahost.plugins.detectmobileservices.DetectMobileServicesPlugin;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;

public class PermissionsHelperClass {
    private Context context;
    private String OSIdent;
    private JsonElement supportedPermissions;
    public void setContext(Context context) {
        this.context = context;
    }
    public void setOSIdent(String OSIdent) {
        this.OSIdent = OSIdent;
    }
    public void setDevicePermissionsGson(JSONObject allPermissions) {
        try {
            if (allPermissions.has(this.OSIdent) && allPermissions.getJSONObject(this.OSIdent).has("alias")) {
                JSONObject alias = allPermissions.getJSONObject(this.OSIdent);
                Gson gson = new Gson();
                this.supportedPermissions = gson.fromJson(alias.getJSONObject("alias").toString() , JsonElement.class);
                if (!this.supportedPermissions.isJsonObject()) {
                    Log.e("Plugin: capacitor-device-permissions","Malformed JSON file (supported_permissions.json) class member '" + this.OSIdent + "' does not exist or the alias sub-member is not a valid JSON Object");
                    throw new RuntimeException("Plugin: capacitor-device-permissions - Malformed JSON file (supported_permissions.json).");
                }
            } else {
                Log.e("Plugin: capacitor-device-permissions","Malformed JSON file (supported_permissions.json) class member '" + this.OSIdent + "' does not exist or the member does not have an 'alias' sub-member");
                throw new RuntimeException("Plugin: capacitor-device-permissions - Malformed JSON file (supported_permissions.json).");
            }
        } catch (JSONException ex) {
            Log.e("Plugin: capacitor-device-permissions","JSON does not contain a member named " + this.OSIdent);
            ex.printStackTrace();
        }
    }

    public JSONObject getParametersFromSupportedPermissionsAlias (String aliasName) throws JSONException {
        JSONObject result = new JSONObject();
        JsonElement permissionElement = this.supportedPermissions.getAsJsonObject().get(aliasName);

        if (permissionElement == null || permissionElement.isJsonNull()) {
            Log.e("Plugin: capacitor-device-permissions","Malformed JSON file (supported_permissions.json) class '" + this.OSIdent + "' does not support " + aliasName + " alias.");
            throw new RuntimeException("Plugin: capacitor-device-permissions - Malformed JSON file (supported_permissions.json).");
        } else {
            JsonObject permissionObject = permissionElement.getAsJsonObject();

            for (Map.Entry<String, JsonElement> entry : permissionObject.entrySet()) {
                String key = entry.getKey();
                JsonElement valueElement = entry.getValue();

                if (valueElement.isJsonPrimitive()) {
                    if (valueElement.getAsJsonPrimitive().isBoolean()) {
                        result.put(key, valueElement.getAsBoolean());
                    } else if (valueElement.getAsJsonPrimitive().isNumber()) {
                        result.put(key, valueElement.getAsNumber());
                    } else if (valueElement.getAsJsonPrimitive().isString()) {
                        result.put(key, valueElement.getAsString());
                    }
                } else if (valueElement.isJsonObject() || valueElement.isJsonArray()) {
                    if (valueElement.isJsonObject()) {
                        result.put(key, valueElement.getAsJsonObject());
                    } else if (valueElement.isJsonArray()) {
                        result.put(key, valueElement.isJsonArray());
                    }
                } else if (valueElement.isJsonNull()) {
                    result.put(key, JSONObject.NULL);
                }
            }
        }
        return result;
    };

    private boolean isConfiguredInManifest(String permission) {
        try {
            PackageManager pm = this.context.getPackageManager();
            if (pm != null) {
                // Get the package info, specifying the permissions array is needed
                String packageName = this.context.getPackageName();
                int flags = PackageManager.GET_PERMISSIONS;
                PackageInfo packageInfo = pm.getPackageInfo(packageName, flags);

                String[] declaredPermissions = packageInfo.requestedPermissions;
                if (declaredPermissions != null) {
                    for (String p : declaredPermissions) {
                        if (p.equals(permission)) {
                            return true; // Permission is declared
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false; // Permission is not declared
    }
    public boolean hasGMS() {
        return DetectMobileServicesPlugin.checkGMS(this.context);
    }
    public boolean hasHMS() {
        return DetectMobileServicesPlugin.checkGMS(this.context);
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