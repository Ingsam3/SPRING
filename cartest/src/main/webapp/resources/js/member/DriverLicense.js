import { AggregateRoot } from '../../shared/core/AggregateRoot';
import { Result } from '../../shared/core/Result';
export class DriverLicense extends AggregateRoot {
    constructor(props, id) {
        super(props, id);
    }
    static create(props, id) {
        return Result.ok(new DriverLicense(props, id));
    }
    static createNew(props) {
        return this.create(Object.assign({}, props), 0);
    }
    get driverName() {
        return this.props.driverName;
    }
    get driverBirthday() {
        return this.props.driverBirthday;
    }
    get licenseNumber() {
        return this.props.licenseNumber;
    }
    get serialNumber() {
        return this.props.serialNumber;
    }
    get verified() {
        var _a;
        return (_a = this.props.verified) !== null && _a !== void 0 ? _a : false;
    }
}
