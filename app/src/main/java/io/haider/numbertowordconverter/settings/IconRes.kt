package io.haider.numbertowordconverter.settings

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class IconRes {
    data class PainterRes(val painter: Painter) : IconRes()
    data class VectorRes(val imageVector: ImageVector) : IconRes()
}