import { WebPlugin } from '@capacitor/core';
import type { DevicePermissionsPlugin } from './definitions';

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    // Leaving the below as an example
    // async echo(_options: { value: string }): Promise<{ value: string | undefined}> {
    //     throw this.unimplemented("echo - Not implemented on web.");
    // }

    async getPermissionStatus(options: { permissions: string }): Promise<{ result: string | undefined }> {
        let permission = options.permissions;
        console.error("getPermissionStatus - Not implemented on the web interface (" + typeof permission + ").", permission);
        return { result: undefined };
    }

    async isAndroid(): Promise<object> {
        return { result: false };
    }

    async isIOS(): Promise<object> {
        return { result: false };
    }

    async isWeb(): Promise<object> {
        return { result: true };
    }

    async hasGMS(): Promise<object> {
        console.error("hasGMS - Not implemented on the web interface.");
        return { result: false };
    }

    async hasHMS(): Promise<object> {
        console.error("hasHMS - Not implemented on the web interface.");
        return { result: false };
    }

}
