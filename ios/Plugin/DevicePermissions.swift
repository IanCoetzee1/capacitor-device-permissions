import Foundation

@objc public class DevicePermissions: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
