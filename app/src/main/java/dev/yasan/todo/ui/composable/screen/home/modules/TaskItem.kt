package dev.yasan.todo.ui.composable.screen.home.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.todo.R
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.ui.preview.TaskListPreviewProvider
import dev.yasan.todo.ui.preview.TaskPreviewProvider
import dev.yasan.todo.ui.theme.dimenDivider
import dev.yasan.todo.ui.theme.grid
import dev.yasan.todo.ui.theme.rubikFamily

@Preview(name = "Task", group = "Task (Light)", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Task", group = "Task (Dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TaskItem(
    @PreviewParameter(TaskPreviewProvider::class) task: Task,
    fontFamily: FontFamily = rubikFamily
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground))
    ) {
        Column(modifier = Modifier.padding(horizontal = grid(2), vertical = grid(1.5f))) {
            Text(
                text = task.title,
                color = colorResource(id = R.color.text_title),
                fontFamily = fontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.requiredHeight(grid()))
            Text(
                text = stringResource(id = R.string.created_on, task.creationDatString),
                color = colorResource(id = R.color.text_desc),
                fontFamily = fontFamily,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
        Divider(color = colorResource(id = R.color.divider), thickness = dimenDivider)
    }

}

@Preview(name = "Task List", group = "Task List (Light)", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Task List", group = "Task List (Dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TaskItemListPreview(@PreviewParameter(TaskListPreviewProvider::class) taskList: List<Task>) {
    Column {
        taskList.forEach { task ->
            TaskItem(task = task)
        }
    }
}