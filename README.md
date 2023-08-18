# capacitor-device-permissions

Capacitor 5 device permissions handling plugin

## Install

```bash
npm install capacitor-device-permissions
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`setup(...)`](#setup)
* [`isPermissionConfigured(...)`](#ispermissionconfigured)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(_options: { value: string; }) => Promise<{ value: string | undefined; }>
```

| Param          | Type                            |
| -------------- | ------------------------------- |
| **`_options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### setup(...)

```typescript
setup(_options: { config: SupportedPermissions; }) => void
```

| Param          | Type                                                                               |
| -------------- | ---------------------------------------------------------------------------------- |
| **`_options`** | <code>{ config: <a href="#supportedpermissions">SupportedPermissions</a>; }</code> |

--------------------


### isPermissionConfigured(...)

```typescript
isPermissionConfigured(_permissionTypes: unknown) => Promise<{ value: string | undefined; }>
```

| Param                  | Type                 |
| ---------------------- | -------------------- |
| **`_permissionTypes`** | <code>unknown</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### Type Aliases


#### SupportedPermissions

<code>{ web: <a href="#record">Record</a>&lt;string, never&gt;, androidGms: { alias: { INTERNET: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.INTERNET', ], }, NOTIFICATIONS: { //Android 13 - Notifications permission required minSDK: 33, maxSDK: 0, permissionsArray: [ 'android.permission.POST_NOTIFICATIONS', ], }, NETWORK_STATE: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.ACCESS_NETWORK_STATE', ], }, CAMERA: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.CAMERA', ], }, BOOT_RECEIVER: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.RECEIVE_BOOT_COMPLETED', ], }, FULL_SCREEN_INTENT: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.USE_FULL_SCREEN_INTENT', ], }, IGNORE_BATTERY_OPTIMIZATIONS: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS', ], }, LOCATION: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.ACCESS_COARSE_LOCATION', 'android.permission.ACCESS_FINE_LOCATION', ], }, BACKGROUND_LOCATION: { minSDK: 0, maxSDK: 0, permissionsArray: [ 'android.permission.ACCESS_BACKGROUND_LOCATION', ], }, } }, ios: [], }</code>


#### Record

Construct a type with a set of properties K of type T

<code>{ [P in K]: T; }</code>

</docgen-api>
