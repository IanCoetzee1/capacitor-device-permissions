import { WebPlugin } from '@capacitor/core';

import type { DevicePermissionsPlugin } from './definitions';

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    // Leaving the below as an example
    // async echo(_options: { value: string }): Promise<{ value: string | undefined}> {
    //     throw this.unimplemented("echo - Not implemented on web.");
    // }

    async IsPermissionGranted(options: { permissions: Array<string> }): Promise<{ result: string | undefined }> {
        let permissions = options.permissions;
        if (!Array.isArray(permissions)) {
            permissions = [permissions];
        }
        console.error("getPermissionStatus - Not implemented on the web interface.", permissions);
        return { result: undefined };
    }

    async IsAndroid(): Promise<object> {
        return { result: false };
    }

    async IsIOS(): Promise<object> {
        return { result: false };
    }

    async IsWeb(): Promise<object> {
        return { result: true };
    }
}
