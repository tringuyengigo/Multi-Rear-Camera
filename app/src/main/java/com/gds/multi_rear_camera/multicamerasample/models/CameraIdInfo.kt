package com.gds.multi_rear_camera.multicamerasample.models

import java.util.Collections.emptyList


data class CameraIdInfo(
    val logicalCameraId: String = "",
    val physicalCameraIds: List<String> = emptyList()
)