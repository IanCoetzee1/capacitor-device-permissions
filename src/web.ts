import {WebPlugin} from '@capacitor/core';

import type {DevicePermissionsPlugin} from './definitions';

export class DevicePermissionsWeb
    extends WebPlugin
    implements DevicePermissionsPlugin {
    async echo(options: { value: string }): Promise<{ value: string }> {
        console.log('ECHO', options);
        return options;
    }

    async isPermissionConfigured(_permissionTypes: Array<string>): Promise<boolean> {
        console.log('Warning: isPermissionConfigured is not available via the Web interface.');
        return false;
    }
}
