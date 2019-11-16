package com.example.flutter_plugin

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterPlugin(registrar: PluginRegistry.Registrar) :MethodChannel.MethodCallHandler {
  private var mRegistrar: PluginRegistry.Registrar? = registrar

  companion object {
    @JvmStatic
    fun registerWith(registrar: PluginRegistry.Registrar) {
      val channel = MethodChannel(registrar.messenger(), "com.flutter.cache_path")
      val instance = FlutterPlugin(registrar)
      channel.setMethodCallHandler(instance)
    }
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    if (call.method == "getCachePath") {
      result.success(getCacheDir())

    } else {
      result.notImplemented()
    }
  }

  private fun getCacheDir(): String {

    //需要context  怎么办？
    return mRegistrar!!.context().cacheDir.path
  }
}
