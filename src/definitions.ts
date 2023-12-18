export interface DevicePermissionsPlugin {
    echo(_options: { value: string }): Promise<{ value: string | undefined }>;
    isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }>;
    hasHMS(): Promise<boolean>;
    hasGMS(): Promise<boolean>;
}

