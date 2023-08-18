export type SupportedPermissions = {
    web: Record<string, never>,
    androidGms: {
        alias: {
            INTERNET: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.INTERNET',
                ],
            },
            NOTIFICATIONS: {
                //Android 13 - Notifications permission required
                minSDK: 33,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.POST_NOTIFICATIONS',
                ],
            },
            NETWORK_STATE: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.ACCESS_NETWORK_STATE',
                ],
            },
            CAMERA: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.CAMERA',
                ],
            },
            BOOT_RECEIVER: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.RECEIVE_BOOT_COMPLETED',
                ],
            },
            FULL_SCREEN_INTENT: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.USE_FULL_SCREEN_INTENT',
                ],
            },
            IGNORE_BATTERY_OPTIMIZATIONS: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS',
                ],
            },
            LOCATION: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.ACCESS_COARSE_LOCATION',
                    'android.permission.ACCESS_FINE_LOCATION',
                ],
            },
            BACKGROUND_LOCATION: {
                minSDK: 0,
                maxSDK: 0,
                permissionsArray: [
                    'android.permission.ACCESS_BACKGROUND_LOCATION',
                ],
            },
        }
    },
    ios: [],
};

export interface DevicePermissionsPlugin {
    echo(_options: { value: string }): Promise<{ value: string | undefined }>;
    setup(_options: { config: SupportedPermissions }): void;
    isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }>;
}


