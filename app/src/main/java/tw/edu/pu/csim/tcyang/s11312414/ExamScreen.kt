package tw.edu.pu.csim.tcyang.s11312414

import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp

@Composable
fun ExamScreen(viewModel: ExamViewModel, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val metrics: DisplayMetrics = context.resources.displayMetrics
    val density = LocalDensity.current

    val widthPx = metrics.widthPixels.toFloat()
    val heightPx = metrics.heightPixels.toFloat()

    LaunchedEffect(Unit) {
        viewModel.setScreenSize(widthPx, heightPx)
    }

    val width by viewModel.screenWidth.collectAsState()
    val height by viewModel.screenHeight.collectAsState()

    val iconSizePx = 300f
    val iconSizeDp = with(density) { iconSizePx.toDp() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .then(modifier)
    ) {
        // 中間的文字資訊
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.happy), // 假設這是中間的圓形圖
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text("瑪莉亞基金會服務大考驗", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("作者 : 資管二B 李羿慧", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("螢幕大小：${width.toInt()} × ${height.toInt()} px", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("成績：0分", fontSize = 18.sp)
        }

        // 四個角色圖示的定位
        with(density) {
            // 👶 嬰兒圖示 (role0)：左邊界，下方切齊螢幕高度 1/2
            val babyOffsetX = 0f
            val babyOffsetY = heightPx / 2f - iconSizePx
            Image(
                painter = painterResource(id = R.drawable.role0), // 使用 role0
                contentDescription = "Baby",
                modifier = Modifier
                    .size(iconSizeDp)
                    .offset(x = babyOffsetX.toDp(), y = babyOffsetY.toDp())
            )

            // 👨 成人圖示 (role2)：左邊界，下方切齊螢幕底部
            val adultOffsetX = 0f
            val adultOffsetY = heightPx - iconSizePx
            Image(
                painter = painterResource(id = R.drawable.role2), // 使用 role2
                contentDescription = "Adult",
                modifier = Modifier
                    .size(iconSizeDp)
                    .offset(x = adultOffsetX.toDp(), y = adultOffsetY.toDp())
            )

            // 👧 兒童圖示 (role1)：右邊界，下方切齊螢幕高度 1/2
            val childOffsetX = widthPx - iconSizePx
            val childOffsetY = heightPx / 2f - iconSizePx
            Image(
                painter = painterResource(id = R.drawable.role1), // 使用 role1
                contentDescription = "Child",
                modifier = Modifier
                    .size(iconSizeDp)
                    .offset(x = childOffsetX.toDp(), y = childOffsetY.toDp())
            )

            // 🧑 一般民眾圖示 (role3)：右邊界，下方切齊螢幕底部
            val citizenOffsetX = widthPx - iconSizePx
            val citizenOffsetY = heightPx - iconSizePx
            Image(
                painter = painterResource(id = R.drawable.role3), // 使用 role3
                contentDescription = "Citizen",
                modifier = Modifier
                    .size(iconSizeDp)
                    .offset(x = citizenOffsetX.toDp(), y = citizenOffsetY.toDp())
            )
        }
    }
}