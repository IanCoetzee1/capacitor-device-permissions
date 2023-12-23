import { WebPlugin } from '@capacitor/core';
import type { DevicePermissionsPlugin } from './definitions';

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    async echo(_options: { value: string }): Promise<{ value: string | undefined}> {
        throw this.unimplemented("echo - Not implemented on web.");
    }

    async isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }> {
        throw this.unimplemented("isPermissionConfigured - Not implemented on web.");
    }

    async isAndroid(): Promise<object> {
        return { value: false };
    }

    async isIOS(): Promise<object> {
        return { value: false };
    }

    async isWeb(): Promise<object> {
        return { value: true };
    }

    async hasGMS(): Promise<object> {
        console.error("hasGMS - Not implemented on web.");
        return { value: false };
    }

    async hasHMS(): Promise<object> {
        console.error("hasHMS - Not implemented on web.");
        return { value: false };
    }

}
