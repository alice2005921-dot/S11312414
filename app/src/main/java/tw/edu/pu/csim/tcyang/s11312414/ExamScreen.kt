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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExamScreen(viewModel: ExamViewModel, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val metrics: DisplayMetrics = context.resources.displayMetrics

    val widthPx = metrics.widthPixels.toFloat()
    val heightPx = metrics.heightPixels.toFloat()

    LaunchedEffect(Unit) {
        viewModel.setScreenSize(widthPx, heightPx)
    }

    val width by viewModel.screenWidth.collectAsState()
    val height by viewModel.screenHeight.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.happy),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            "瑪莉亞基金會服務大考驗",
            fontSize = 18.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            "作者 : 資管二B 李羿慧",
            fontSize = 18.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            "螢幕大小：$width × $height",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            "成績：0分",
            fontSize = 18.sp,
        )
    }
}
