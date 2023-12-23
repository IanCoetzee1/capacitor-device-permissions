export interface DevicePermissionsPlugin {
    echo(_options: { value: string }): Promise<{ value: string | undefined }>;
    isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }>;
    isAndroid(): Promise<object>;
    isIOS(): Promise<object>;
    isWeb(): Promise<object>;
    hasGMS(): Promise<object>;
    hasHMS(): Promise<object>;
}

