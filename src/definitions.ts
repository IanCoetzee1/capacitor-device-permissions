export interface DevicePermissionsPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;
    isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | null }>;
}
