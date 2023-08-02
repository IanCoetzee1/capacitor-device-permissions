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
* [`isPermissionConfigured(...)`](#ispermissionconfigured)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(_options: { value: string; }) => Promise<{ value: string; }>
```

| Param          | Type                            |
| -------------- | ------------------------------- |
| **`_options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

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
