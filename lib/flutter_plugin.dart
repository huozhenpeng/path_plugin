import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPlugin {
  static const MethodChannel _channel =
  const MethodChannel('com.flutter.cache_path');

  static Future<String> get platformCacheDir async {
    final String version = await _channel.invokeMethod('getCachePath');
    return version;
  }
}
