import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(DevicePermissionsPlugin)
public class DevicePermissionsPlugin: CAPPlugin {
//    private let implementation = DevicePermissions()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
//        call.resolve([
//            "value": implementation.echo(value)
//        ])
    }
}
