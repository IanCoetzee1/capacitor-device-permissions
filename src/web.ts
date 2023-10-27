import { WebPlugin } from '@capacitor/core';

import type { DevicePermissionsPlugin } from './definitions';
import { SupportedPermissions } from "./definitions";

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    async echo(_options: { value: string }): Promise<{ value: string | undefined}> {
        console.log('Warning: isPermissionConfigured is not available via the Web interface.');
        return { value: undefined }
    }
    setup(_options: { config: SupportedPermissions }): void {
        console.log('Warning: setup is not available via the Web interface.');
    }
    async isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }> {
        console.log('Warning: isPermissionConfigured is not available via the Web interface.');
        return { value: undefined };
    }
}
