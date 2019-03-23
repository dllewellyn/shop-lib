if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Shop'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Shop'.");
}
var Shop = function (_, Kotlin) {
  'use strict';
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  function hello() {
    return 'Hello from JS';
  }
  function ShopGenerator() {
  }
  ShopGenerator.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'ShopGenerator',
    interfaces: []
  };
  function Shop(name) {
    this.name = name;
  }
  Shop.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Shop',
    interfaces: []
  };
  Shop.prototype.component1 = function () {
    return this.name;
  };
  Shop.prototype.copy_61zpoe$ = function (name) {
    return new Shop(name === void 0 ? this.name : name);
  };
  Shop.prototype.toString = function () {
    return 'Shop(name=' + Kotlin.toString(this.name) + ')';
  };
  Shop.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    return result;
  };
  Shop.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.name, other.name))));
  };
  function ShopLocation(lat, lon) {
    this.lat = lat;
    this.lon = lon;
  }
  ShopLocation.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ShopLocation',
    interfaces: []
  };
  ShopLocation.prototype.component1 = function () {
    return this.lat;
  };
  ShopLocation.prototype.component2 = function () {
    return this.lon;
  };
  ShopLocation.prototype.copy_3pjtqy$ = function (lat, lon) {
    return new ShopLocation(lat === void 0 ? this.lat : lat, lon === void 0 ? this.lon : lon);
  };
  ShopLocation.prototype.toString = function () {
    return 'ShopLocation(lat=' + Kotlin.toString(this.lat) + (', lon=' + Kotlin.toString(this.lon)) + ')';
  };
  ShopLocation.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.lat) | 0;
    result = result * 31 + Kotlin.hashCode(this.lon) | 0;
    return result;
  };
  ShopLocation.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.lat, other.lat) && Kotlin.equals(this.lon, other.lon)))));
  };
  function Sample() {
  }
  Sample.prototype.checkMe = function () {
    return 12;
  };
  Sample.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Sample',
    interfaces: []
  };
  function Platform() {
    Platform_instance = this;
    this.name = 'JS';
  }
  Platform.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Platform',
    interfaces: []
  };
  var Platform_instance = null;
  function Platform_getInstance() {
    if (Platform_instance === null) {
      new Platform();
    }
    return Platform_instance;
  }
  var package$sample = _.sample || (_.sample = {});
  package$sample.hello = hello;
  var package$shop = _.shop || (_.shop = {});
  var package$local = package$shop.local || (package$shop.local = {});
  package$local.ShopGenerator = ShopGenerator;
  var package$models = package$local.models || (package$local.models = {});
  package$models.Shop = Shop;
  package$models.ShopLocation = ShopLocation;
  package$sample.Sample = Sample;
  Object.defineProperty(package$sample, 'Platform', {
    get: Platform_getInstance
  });
  Kotlin.defineModule('Shop', _);
  return _;
}(typeof Shop === 'undefined' ? {} : Shop, kotlin);
