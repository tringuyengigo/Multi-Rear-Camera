package com.gds.multi_rear_camera.multicamerasample.listeners

import android.graphics.SurfaceTexture
import android.view.TextureView
import com.gds.multi_rear_camera.multicamerasample.models.State
import com.gds.multi_rear_camera.multicamerasample.models.SurfaceTextureInfo
import com.gds.multi_rear_camera.multicamerasample.ui.AutoFitTextureView
import kotlin.coroutines.suspendCoroutine
import kotlin.coroutines.resume

class SurfaceTextureWaiter(private val textureView: AutoFitTextureView) {

    suspend fun textureIsReady(): SurfaceTextureInfo =
            suspendCoroutine { cont ->
                textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
                    override fun onSurfaceTextureSizeChanged(
                        cameraDevice: SurfaceTexture,
                        width: Int,
                        height: Int
                    ) {
                        cont.resume(SurfaceTextureInfo(State.ON_TEXTURE_SIZE_CHANGED, width, height))
                    }

                    override fun onSurfaceTextureUpdated(p0: SurfaceTexture) {
                    }

                    override fun onSurfaceTextureDestroyed(p0: SurfaceTexture): Boolean = true

                    override fun onSurfaceTextureAvailable(
                        p0: SurfaceTexture,
                        width: Int,
                        height: Int
                    ) {
                        cont.resume(SurfaceTextureInfo(State.ON_TEXTURE_AVAILABLE, width, height))
                    }
                }
            }
}