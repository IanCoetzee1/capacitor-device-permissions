export interface DevicePermissionsPlugin {
    //Lewaving the echo as an example note the _ in paramters to define a paramater that is not required
    //echo(_permissionAliasString: string): Promise<{ value: string | undefined }>;
    IsPermissionGranted(options: { permissions: Array<string> }): Promise<{ result: string | undefined }>;
    IsAndroid(): Promise<object>;
    IsIOS(): Promise<object>;
    IsWeb(): Promise<object>;
}

