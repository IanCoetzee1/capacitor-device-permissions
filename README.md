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
setup(_options: { config: typeof SupportedPermissions; }) => void
```

| Param          | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **`_options`** | <code>{ config: { web: {}; androidGms: { alias: { INTERNET: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; NOTIFICATIONS: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; NETWORK_STATE: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; CAMERA: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; BOOT_RECEIVER: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; FULL_SCREEN_INTENT: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; IGNORE_BATTERY_OPTIMIZATIONS: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; LOCATION: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; BACKGROUND_LOCATION: { minSDK: number; maxSDK: number; permissionsArray: string[]; }; }; }; ios: never[]; }; }</code> |

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

</docgen-api>
