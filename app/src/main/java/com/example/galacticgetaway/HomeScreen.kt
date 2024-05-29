package com.example.galacticgetaway

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.galacticgetaway.ui.theme.BebasNeueFontFamily
import com.example.galacticgetaway.ui.theme.GalacticGetawayTheme
import com.example.galacticgetaway.ui.theme.InterFontFamily


//0xFF is the replacement for #
val Background = Color(0xFF090011)  // defines a variable named Background of type Color.
val Primary = Color (0xFF7920C2) // defines a variable named Primary of type Color.


@Composable // // responsible for defining UI components in Jetpack Compose.
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface( //A container that fills the entire screen and has a background color defined above
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column( // aligns the rows to appear next to each other
            verticalArrangement = Arrangement.Center, // Content inside the container will be aligned vertically centered within the container
            horizontalAlignment = Alignment.Start, // Content inside the container will be aligned horizontally to the start (left) within the container.
            modifier = modifier // modifier is used to apply different modifications to a Compose UI component.
                .padding(10.dp)
                .verticalScroll(rememberScrollState()) // Add vertical scroll modifier
        ) {
            Spacer(modifier = modifier.height(10.dp)) // is used to create an empty space between other UI elements.

            // Username with a profile image
            Row( //arranges components in the row in a horizontal sequence.
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text( // allows you to display text
                    text = "Hallo, Martian",
                    fontSize = 18.sp,
                    fontFamily = InterFontFamily,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Image( // allows you to display an image
                    painter = painterResource(id = R.drawable.profile), //where the image comes from (drawable)
                    contentDescription = "Profile image of a astronaut with his hand up", //Description of the image
                    modifier = Modifier.size(47.dp) // Set a fixed size for the image
                )
            }

            Spacer(modifier = modifier.height(10.dp))

            // Search input field
            val borderColor = Color(0xFFFFFFFF) // defines a variable named borderColor of type Color.
            val backgroundColor = Color.Transparent  //defines a variable named background of type Color that is transparent.
            val textColor = Color(0x99FFFFFF)  //defines a variable named borderColor of type Color.
            Row( //arranges components in the row in a horizontal sequence.
                modifier = Modifier
                    .padding(16.dp) // adds a padding of 16dp
                    .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(size = 50.dp))  // adds a border of 2 dp, a color that is defined as background, a shape that is RoundedCornerShape with a size of 50 dp
                    .width(388.dp)  // adds a width of 388 dp
                    .height(51.dp), // adds a width of 51 dp
                verticalAlignment = Alignment.CenterVertically // aligning an element vertically within its container
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search), //where the image comes from (drawable)
                    contentDescription = "Search icon", //Description of the image
                    modifier = Modifier
                        .size(47.dp) // Set a fixed size for the image
                        .padding(start = 16.dp, end = 10.dp) // Add padding between image and text
                        .align(Alignment.CenterVertically) // Align image vertically with the text
                )
                BasicTextField( //used to create a text input field with customizable properties
                    value = "search for a planet...", // current text to be displayed in the text field
                    onValueChange = { /* Handle value change */ }, //used to handle the text change events, none has been set
                    modifier = Modifier
                        .weight(1f) //makes the text field take up all available space within its parent.
                        .padding(vertical = 16.dp) // Add vertical padding of 16 dp, for the text
                        .background(color = backgroundColor) // Sets the background color of the text field to backgroundColor that has been defined.
                        .fillMaxHeight(), // Makes the text field fill the maximum available height of its parent.
                    textStyle = TextStyle(
                        fontFamily = InterFontFamily,// sets the text a specific font family that has been added.
                        fontSize = 16.sp, // set the side of the text ti 16 sp
                        color = textColor, // Sets the text color to textColor, that has been defined.
                        textAlign = TextAlign.Left, // Center align the text
                    )
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            // Popular Now, heading
            Text(
                text = "Popular Now \uD83D\uDD25", // current text to be displayed as text
                fontSize = 32.sp, // set the side of the text ti 16 sp
                fontFamily = BebasNeueFontFamily, // sets the text a specific font family that has been added.
                color = Color.White, // Sets the text color to white
            )

            // Add the three cards to be able to horizontalScroll
            Box( // is a layout composable that allows you to place and arrange child composable within it.
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                // Column for images and boxes
                Column { // aligns the rows to appear next to each other
                    // Row for images
                    Row( //arranges components in the row in a horizontal sequence.
                        modifier = Modifier
                            .fillMaxWidth() // Makes the text field fill the maximum available width of its parent.
                            .height(165.dp) // Set the height of the row to ensure the images are not cut off
                            .zIndex(1f), // Bring the row of images to the front
                        horizontalArrangement = Arrangement.spacedBy(16.dp) // Add spacing between the images
                    ) {
                        // Spacer to align Mars image
                        Spacer(modifier = Modifier.width(30.dp)) // adds a width of 30 dp

                        // Image 1
                        Image(
                            painter = painterResource(id = R.drawable.mars), //where the image comes from (drawable)
                            contentDescription = "Mars Image", //Description of the image
                            contentScale = ContentScale.Crop, // Scale the image to fill the available space without cropping
                            modifier = Modifier
                                .size(161.dp) // Set the size of the image
                                .offset(y = (50).dp) // Adjust the offset to move the image upwards (negative values move it upwards)
                        )

                        // Spacer between images
                        Spacer(modifier = Modifier.width(60.dp)) // adds a width of 60 dp

                        // Image 2
                        Image(
                            painter = painterResource(id = R.drawable.saturn), //where the image comes from (drawable)
                            contentDescription = "Saturn Image", //Description of the image
                            contentScale = ContentScale.Crop, // Scale the image to fill the available space without cropping
                            modifier = Modifier
                                .size(151.dp) // Set the size of the image
                                .offset(y = (50).dp) // Adjust the offset to move the image upwards (negative values move it upwards)
                        )

                        // Spacer between images
                        Spacer(modifier = Modifier.width(60.dp)) // adds a width of 60 dp

                        // Image 3
                        Image(
                            painter = painterResource(id = R.drawable.saturn), //where the image comes from (drawable)
                            contentDescription = "Neptune Image", //Description of the image
                            contentScale = ContentScale.Crop, // Scale the image to fill the available space without cropping
                            modifier = Modifier
                                .size(151.dp) // Set the size of the image
                                .offset(y = (50).dp) // Adjust the offset to move the image upwards (negative values move it upwards)
                        )
                    }

                    // Spacer between rows
                    Spacer(modifier = Modifier.height(20.dp))

                    // Row for boxes
                    Row( //arranges components in the row in a horizontal sequence.
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp) // Add spacing between the boxes
                    ) {
                        // Container 1
                        Box( // is a layout composable that allows you to place and arrange child composable within it.
                            modifier = Modifier
                                .background(color = Color(0xFF11083E), shape = RoundedCornerShape(size = 20.dp)) // adds a color that has a specific color, a shape that is RoundedCornerShape with a size of 50 dp
                                .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp) // Add top padding and other padding as needed
                                .width(200.dp) // adds a width of 200 dp
                                .height(200.dp) // adds a width of 200 dp
                        ) {
                            // Column for text elements
                            Column( // aligns the rows to appear next to each other
                                horizontalAlignment = Alignment.CenterHorizontally) { //is an alignment option that positions an element or layout in the center horizontally within its parent container.
                                // Heading text
                                Text(
                                    text = "Mars", // current text to be displayed as text
                                    fontSize = 40.sp,  //Sets the font size to 40 sp
                                    fontFamily = BebasNeueFontFamily, // set the font family that has been added
                                    color = Color.White, //Sets the text color to white
                                    textAlign = TextAlign.Center, //Center align the text
                                    modifier = Modifier
                                        .padding(top = 8.dp) // Add padding top
                                )
                                // Line under the heading text
                                Divider( // adds a line
                                    color = Color(0xFFF2994A),
                                    thickness = 4.dp, // add a thickness of 4 dp
                                    modifier = Modifier
                                        .width(23.dp) // Set the specific length of 23 dp to the line
                                        .padding(top = 8.dp, bottom = 15.dp) // Add padding top and bottom of the line
                                )
                                // New text below heading
                                Text(
                                    text = "Engage in thrilling activities like rover expeditions and marvel at the breathtaking Martian sunsets.", // current text to be displayed as text
                                    fontSize = 12.sp, //Sets the font size to 12 sp
                                    fontFamily = InterFontFamily, // set the font family that has been added
                                    color = Color.White,  //Sets the text color to white
                                    textAlign = TextAlign.Center //Center align the text
                                )
                            }
                        }

                        // Container 2
                        Box( // is a layout composable that allows you to place and arrange child composable within it.
                            modifier = Modifier
                                .background(color = Color(0xFF11083E), shape = RoundedCornerShape(size = 20.dp)) // adds a color that has a specific color, a shape that is RoundedCornerShape with a size of 20 dp
                                .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp) // Add top padding and other padding as needed
                                .width(200.dp) // adds a width of 200 dp
                                .height(200.dp) // adds a width of 200 dp
                        ) {
                            // Column for text elements
                            Column( // aligns the rows to appear next to each other
                                horizontalAlignment = Alignment.CenterHorizontally) {// is an alignment option that positions an element or layout in the center horizontally within its parent container.
                                // Heading text
                                Text(
                                    text = "Saturn", // current text to be displayed as text
                                    fontSize = 40.sp, //Sets the font size to 40 sp
                                    fontFamily = BebasNeueFontFamily, // set the font family that has been added
                                    color = Color.White, //Sets the text color to white
                                    textAlign = TextAlign.Center, //Center align the text
                                    modifier = Modifier
                                        .padding(top = 8.dp) // Add padding top
                                )
                                // Line under the heading text
                                Divider( // adds a line
                                    color = Color(0xFFF2994A),
                                    thickness = 4.dp, // add a thickness of 4 dp
                                    modifier = Modifier
                                        .width(23.dp) // Set the specific length of 23 dp to the line
                                        .padding(top = 8.dp, bottom = 15.dp) // Add padding top and bottom of the line
                                )
                                // New text below heading
                                Text(
                                    text = "Experience weightlessness as you float among Saturn's rings to witness the grandeur of the gas giant.", // current text to be displayed as text
                                    fontSize = 12.sp, //Sets the font size to 12 sp
                                    fontFamily = InterFontFamily, // set the font family that has been added
                                    color = Color.White, //Sets the text color to white
                                    textAlign = TextAlign.Center //Center align the text
                                )
                            }
                        }

                        // Container 3
                        Box( // is a layout composable that allows you to place and arrange child composable within it.
                            modifier = Modifier
                                .background(color = Color(0xFF11083E), shape = RoundedCornerShape(size = 20.dp)) // adds a color that has a specific color, a shape that is RoundedCornerShape with a size of 20 dp
                                .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 20.dp) // Add top padding and other padding as needed
                                .width(200.dp) // adds a width of 200 dp
                                .height(200.dp) // adds a width of 200 dp
                        ) {
                            // Column for text elements
                            Column( // aligns the rows to appear next to each other
                                horizontalAlignment = Alignment.CenterHorizontally) {// is an alignment option that positions an element or layout in the center horizontally within its parent container.
                                // Heading text
                                Text(
                                    text = "Pluto", // current text to be displayed as text
                                    fontSize = 40.sp, //Sets the font size to 40 sp
                                    fontFamily = BebasNeueFontFamily, // set the font family that has been added
                                    color = Color.White, //Sets the text color to white
                                    textAlign = TextAlign.Center, //Center align the text
                                    modifier = Modifier
                                        .padding(top = 8.dp) // Add padding top
                                )
                                // Line under the heading text
                                Divider( // adds a line
                                    color = Color(0xFFF2994A),
                                    thickness = 4.dp, // add a thickness of 4 dp
                                    modifier = Modifier
                                        .width(23.dp) // Set the specific length of 23 dp to the line
                                        .padding(top = 8.dp, bottom = 15.dp) // Add padding top and bottom of the line
                                )
                                // New text below heading
                                Text(
                                    text = "Uncover the mysteries of the distant dwarf “planet” Pluto. Traverse its icy plains that resides on the outskirts of our solar system.", // current text to be displayed as text
                                    fontSize = 12.sp, //Sets the font size to 12 sp
                                    fontFamily = InterFontFamily,  // set the font family that has been added
                                    color = Color.White,  //Sets the text color to white
                                    textAlign = TextAlign.Center  //Center align the text
                                )
                            }
                        }
                    }

                }
            }

            Spacer(modifier = modifier.height(15.dp))

            // View planets button
            Button( //  representing a clickable area that users can interact with
                onClick = { /*Do something*/ }, // callback function that gets invoked when the button is clicked, currently doesn't have a function
                colors = ButtonDefaults.textButtonColors( //  is used to customize the colors, with containerColor set to Primary, which refers to a color defined at the top.
                    containerColor = Primary // defined at the top
                ),
                modifier = modifier.fillMaxWidth() //is applied to make the button take up the maximum available width.
            ) {
                Text(
                    text = "View all planets", // current text to be displayed as text
                    fontSize = 16.sp, //Sets the font size to 16 sp
                    fontFamily = InterFontFamily, // set the font family that has been added
                    color = Color.White, //Sets the text color to white
                )
            }

            Spacer(modifier = modifier.height(15.dp))

            // Learn how to travel box
            Box( // is a layout composable that allows you to place and arrange child composable within it.
                modifier = Modifier
                    .background(color = Color(0xFF11083E), shape = RoundedCornerShape(size = 20.dp)) // adds a color that has a specific color, a shape that is RoundedCornerShape with a size of 20 dp
                    .padding(20.dp) // Added padding of 20 dp
            ) {
                Row( //arranges components in the row in a horizontal sequence.
                    modifier = Modifier.fillMaxWidth(), //is applied to make the button take up the maximum available width.
                    verticalAlignment = Alignment.CenterVertically // aligning an element vertically within its container
                ) {
                    // Column for the text and button
                    Column( // aligns the rows to appear next to each other
                        horizontalAlignment = Alignment.Start, // Content inside the container will be aligned horizontally to the start (left) within the container.
                        verticalArrangement = Arrangement.spacedBy(8.dp), // Add spacing between the columns
                        modifier = Modifier.weight(1f) // Take remaining space
                    ) {
                        Text(
                            text = "Learn how to travel in Space", // current text to be displayed as text
                            fontSize = 24.sp, //Sets the font size to 24 sp
                            fontFamily = BebasNeueFontFamily, // set the font family that has been added
                            color = Color.White //Sets the text color to white
                        )

                        Text(
                            text = "You can learn about rocket science here", // current text to be displayed as text
                            fontSize = 16.sp, //Sets the font size to 16 sp
                            fontFamily = InterFontFamily, // set the font family that has been added
                            color = Color.White //Sets the text color to white
                        )

                        Button(
                            onClick = { /* Add button action here */ }, // callback function that gets invoked when the button is clicked, currently doesn't have a function
                            colors = ButtonDefaults.textButtonColors( //  is used to customize the colors, with containerColor set to Primary, which refers to a color defined at the top.
                                containerColor = Primary // defined at the top
                            ),
                        ) {
                            Text(
                                text = "Explore", // current text to be displayed as text
                                fontSize = 16.sp, //Sets the font size to 16 sp
                                fontFamily = InterFontFamily, // set the font family that has been added
                                color = Color.White //Sets the text color to white
                            )
                        }
                    }
                    // Column for the image
                    Column( // aligns the rows to appear next to each other
                        horizontalAlignment = Alignment.CenterHorizontally, //is an alignment option that positions an element or layout in the center horizontally within its parent container.
                        verticalArrangement = Arrangement.Center // Content inside the container will be aligned vertically centered within the container
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rocket), //where the image comes from (drawable)
                            contentDescription = "Rocking taking off", //Description of the image
                            modifier = Modifier.size(159.dp) // Set a fixed size for the image
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true) //  to generate a preview of a composable function
@Composable // responsible for defining UI components in Jetpack Compose.
fun HomeScreePreview() { // used to generate a preview of the HomeScreen composable function.
    GalacticGetawayTheme { //wraps the content of the preview with a theme.
        HomeScreen() // This is a call to the HomeScreen composable function
    }
}
