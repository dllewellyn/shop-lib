if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Shop_test'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Shop_test'.");
}
if (typeof Shop === 'undefined') {
  throw new Error("Error loading module 'Shop_test'. Its dependency 'Shop' was not found. Please, check whether 'Shop' is loaded prior to 'Shop_test'.");
}
if (typeof this['kotlin-test'] === 'undefined') {
  throw new Error("Error loading module 'Shop_test'. Its dependency 'kotlin-test' was not found. Please, check whether 'kotlin-test' is loaded prior to 'Shop_test'.");
}
var Shop_test = function (_, Kotlin, $module$Shop, $module$kotlin_test) {
  'use strict';
  var Sample = $module$Shop.sample.Sample;
  var assertTrue = $module$kotlin_test.kotlin.test.assertTrue_ifx8ge$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var hello = $module$Shop.sample.hello;
  var contains = Kotlin.kotlin.text.contains_li3zpu$;
  var test = $module$kotlin_test.kotlin.test.test;
  var suite = $module$kotlin_test.kotlin.test.suite;
  function SampleTests() {
  }
  SampleTests.prototype.testMe = function () {
    assertTrue((new Sample()).checkMe() > 0);
  };
  SampleTests.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SampleTests',
    interfaces: []
  };
  function SampleTestsJS() {
  }
  SampleTestsJS.prototype.testHello = function () {
    assertTrue(contains(hello(), 'JS'));
  };
  SampleTestsJS.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SampleTestsJS',
    interfaces: []
  };
  var package$sample = _.sample || (_.sample = {});
  package$sample.SampleTests = SampleTests;
  package$sample.SampleTestsJS = SampleTestsJS;
  suite('sample', false, function () {
    suite('SampleTests', false, function () {
      test('testMe', false, function () {
        return (new SampleTests()).testMe();
      });
    });
    suite('SampleTestsJS', false, function () {
      test('testHello', false, function () {
        return (new SampleTestsJS()).testHello();
      });
    });
  });
  Kotlin.defineModule('Shop_test', _);
  return _;
}(typeof Shop_test === 'undefined' ? {} : Shop_test, kotlin, Shop, this['kotlin-test']);
