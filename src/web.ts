import {WebPlugin} from '@capacitor/core';

import type {DevicePermissionsPlugin} from './definitions';

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    async echo(_options: { value: string }): Promise<{ value: string }> {
        throw new Error('Warning: echo is not available via the Web interface.');
    }

    async isPermissionConfigured(_permissionTypes: unknown): Promise<{ value: string | undefined }> {
        throw new Error('Warning: isPermissionConfigured is not available via the Web interface.');
    }
}
