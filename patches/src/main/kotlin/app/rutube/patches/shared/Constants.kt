package app.rutube.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    /**
     * RUTUBE.
     *
     * Confirmed against ru.rutube.app.tv 31.19.0.TV-rustore pulled from a device: a single base.apk
     * (no splits), 6 dex files, no Flutter/React Native.
     */
    val COMPATIBILITY_RUTUBE =
            Compatibility(
                    name = "RUTUBE",
                    packageName = "ru.rutube.app.tv",
                    apkFileType = ApkFileType.APK,
                    // Approximate RUTUBE brand violet; adjust to the exact launcher icon
                    // background.
                    appIconColor = 0x7B2FF7,
                    targets =
                            listOf(
                                    // The version these patches are developed against. Note RUTUBE
                                    // is not on
                                    // apkmirror.com or uptodown.com and the site only links app
                                    // stores, so the
                                    // practical way to obtain this exact apk is to install from
                                    // RuStore and pull
                                    // it off the device:
                                    //   adb shell pm path ru.rutube.app.tv && adb pull <path>
                                    AppTarget(
                                            version = "31.19.0.TV-rustore",
                                    ),
                                    // Newer builds are expected to work while the ad SDK keeps its
                                    // shape.
                                    AppTarget(
                                            version = null,
                                            isExperimental = true,
                                    ),
                            ),
            )
}
