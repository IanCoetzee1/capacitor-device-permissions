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
        return { return: false };
    }

    async hasGMS(): Promise<object> {
        console.error("hasGMS - Not implemented on web.");
        return { return: false };
    }
    async hasHMS(): Promise<object> {
        console.error("hasHMS - Not implemented on web.");
        return { return: false };
    }

}
