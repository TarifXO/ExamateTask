import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.ui.theme.disabledTextColor
import com.example.examatetask.ui.theme.primaryColor
import com.example.examatetask.view.components.DisabledStep
import com.example.examatetask.view.components.SimpleStep1Drawable

@Composable
fun StepItem(stepNumber: String, stepTitle: String, isDisabled: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (isDisabled) {
            DisabledStep(text = stepNumber)
        } else {
            SimpleStep1Drawable(text = stepNumber)
        }
        Text(
            text = stepTitle,
            modifier = Modifier.padding(start = 12.dp)
                .offset(y = (-18).dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = if (isDisabled) disabledTextColor else primaryColor
        )
    }
}