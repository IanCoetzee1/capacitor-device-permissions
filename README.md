# capacitor-device-permissions

Capacitor 5 device permissions handling plugin

## Install

```bash
npm install capacitor-device-permissions
npx cap sync
```

## API

<docgen-index>

* [`getPermissionStatus(...)`](#getpermissionstatus)
* [`isAndroid()`](#isandroid)
* [`isIOS()`](#isios)
* [`isWeb()`](#isweb)
* [`hasGMS()`](#hasgms)
* [`hasHMS()`](#hashms)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getPermissionStatus(...)

```typescript
getPermissionStatus(options: { permissions: string; }) => Promise<{ result: string | undefined; }>
```

| Param         | Type                                  |
| ------------- | ------------------------------------- |
| **`options`** | <code>{ permissions: string; }</code> |

**Returns:** <code>Promise&lt;{ result: string; }&gt;</code>

--------------------


### isAndroid()

```typescript
isAndroid() => Promise<object>
```

**Returns:** <code>Promise&lt;object&gt;</code>

--------------------


### isIOS()

```typescript
isIOS() => Promise<object>
```

**Returns:** <code>Promise&lt;object&gt;</code>

--------------------


### isWeb()

```typescript
isWeb() => Promise<object>
```

**Returns:** <code>Promise&lt;object&gt;</code>

--------------------


### hasGMS()

```typescript
hasGMS() => Promise<object>
```

**Returns:** <code>Promise&lt;object&gt;</code>

--------------------


### hasHMS()

```typescript
hasHMS() => Promise<object>
```

**Returns:** <code>Promise&lt;object&gt;</code>

--------------------

</docgen-api>
