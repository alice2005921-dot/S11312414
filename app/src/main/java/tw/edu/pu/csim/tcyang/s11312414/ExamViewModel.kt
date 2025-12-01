package tw.edu.pu.csim.tcyang.s11312414

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExamViewModel : ViewModel() {

    // 使用 Float 以符合 1080.0 × 1920.0 的格式
    private val _screenWidth = MutableStateFlow(0f)
    val screenWidth = _screenWidth.asStateFlow()

    private val _screenHeight = MutableStateFlow(0f)
    val screenHeight = _screenHeight.asStateFlow()

    // 設定螢幕大小（Float）
    fun setScreenSize(width: Float, height: Float) {
        _screenWidth.value = width
        _screenHeight.value = height
    }
}