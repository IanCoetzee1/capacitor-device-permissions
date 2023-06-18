export interface DevicePermissionsPlugin {
    echo(options: { value: string }): Promise<{ value: string }>;

    isPermissionConfigured(permissionTypes: Array<string>): Promise<boolean>;
}
