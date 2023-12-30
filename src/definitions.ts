export interface DevicePermissionsPlugin {
    //Lewaving the echo as an example note the _ in paramters to define a paramater that is not required
    //echo(_permissionAliasString: string): Promise<{ value: string | undefined }>;
    getPermissionStatus(options: { permissions: string }): Promise<{ result: string | undefined }>;
    isAndroid(): Promise<object>;
    isIOS(): Promise<object>;
    isWeb(): Promise<object>;
    hasGMS(): Promise<object>;
    hasHMS(): Promise<object>;
}

