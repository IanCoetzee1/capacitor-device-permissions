import Capacitor
import Foundation

@objc(DetectMobileServicesPlugin)
public class DetectMobileServicesPlugin: CAPPlugin {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
