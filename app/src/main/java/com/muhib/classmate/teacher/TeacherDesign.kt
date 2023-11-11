package com.muhib.classmate.teacher

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhib.classmate.designs.ButtonDesigner
import com.muhib.classmate.ui.theme.backgroundDark
import com.muhib.classmate.ui.theme.backgroundLight
import com.muhib.classmate.ui.theme.red

@Preview(showBackground = true)
@Composable
fun Teacher() {
    val color = if (isSystemInDarkTheme()) { backgroundDark } else { backgroundLight }

    Column(modifier = Modifier
        .wrapContentWidth()
        .fillMaxHeight()
        .background(color = color)
        .padding(top = 24.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            elevation = CardDefaults.cardElevation(1.dp),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(
                containerColor = color,
            )
        ) {
            CourseList(courseList = listOf(Course("Course Code", "Course Title", "Time", "Place", "Status")), fontWeight = FontWeight.ExtraBold)
            CourseList(courseList = CourseRepository().getAllCourse())
        }

        /* TODO: Complete Lambda Function */
        ButtonDesigner(text = "Add Course", backgroundColor = red, textColor = Color.White, modifier = Modifier.padding(top = 32.dp)) {}
        Spacer(modifier = Modifier.padding(top = 16.dp))
        /* TODO: Complete Lambda Function */
        ButtonDesigner(text = "Remove Course", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
        ) {}
        /* TODO: Complete Lambda Function */
        ButtonDesigner(text = "Add Term Test", backgroundColor = red, textColor = Color.White, modifier = Modifier.padding(top = 32.dp)) {}
        Spacer(modifier = Modifier.padding(top = 16.dp))
        /* TODO: Complete Lambda Function */
        ButtonDesigner(text = "Remove Term Test", backgroundColor = color, textColor = red, Modifier.border(2.dp, red, RoundedCornerShape(4.dp))
        ) {}
    }
}

@Composable
fun CourseDetails(course: Course, modifier: Modifier = Modifier, fontWeight: FontWeight = FontWeight.Normal) {
    val color = if (isSystemInDarkTheme()) { backgroundDark } else { backgroundLight }

    Card(modifier = modifier
        .wrapContentWidth()
        .horizontalScroll(rememberScrollState()),
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = color,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Row {
            CourseText(text = course.code, fontWeight = fontWeight)
            CourseText(text = course.title, fontWeight = fontWeight)
            CourseText(text = course.time, fontWeight = fontWeight)
            CourseText(text = course.place, fontWeight = fontWeight)
            CourseText(text = course.status, fontWeight = fontWeight)
        }
    }
}

@Composable
fun CourseList(courseList: List<Course>, modifier: Modifier = Modifier, fontWeight: FontWeight = FontWeight.Normal) {
    LazyColumn(modifier = modifier
        .wrapContentWidth()
    ) {
        items(courseList) {
                course -> CourseDetails(
                    course = course,
                    modifier =  Modifier.padding(
                        bottom = if(course.equals(course.status)) { 4.dp } else { 0.dp }
                    ),
                    fontWeight = fontWeight
                )
        }
    }
}

@Composable
fun CourseText(text: String, modifier: Modifier = Modifier, fontWeight: FontWeight = FontWeight.Normal) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = fontWeight,
            modifier = modifier
                .fillMaxHeight()
                .width(200.dp)
                .padding(horizontal = 2.dp, vertical = 4.dp),
        )
}

