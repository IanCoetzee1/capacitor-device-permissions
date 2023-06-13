export interface DevicePermissionsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
