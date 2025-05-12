package com.example.mastercardapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign


@Composable
fun TermsScreen(navController: NavHostController) {
    Scaffold(
        containerColor = Color.Black,
        // btm bar - same as intro screen
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF141414))
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        navController.navigate(Screen.Cover.route) {
                            popUpTo(Screen.Cover.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier.weight(0.6f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFF6600)),
                    border = BorderStroke(1.dp, Color(0xFFFF6600))
                ) {
                    Text("Disagree")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        navController.navigate(Screen.Cover.route) {
                            popUpTo(Screen.Cover.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600))
                ) {
                    Text("Agree")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFF141414))
        ) {
            // top bar - same as intro screen
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF141414))
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.height(24.dp)
                )

                Button(
                    onClick = {
                        navController.navigate(Screen.Cover.route) {
                            popUpTo(Screen.Cover.route) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
                ) {
                    Text("Close", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Terms and Conditions",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // actual terms
            // Todo: Add scroll bar
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFF1E1E1E), shape = RoundedCornerShape(12.dp))
                    .padding(20.dp)
                    // make scrollable
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "1. Personal Information We May Collect",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = longTermsText,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

// Todo: Maybe check if can use rich text like markdown
private val longTermsText = """
Personal Information” means any information relating to an identified or identifiable individual. We may collect the following categories of Personal Information:
- Transaction information, such as personal account number, the merchant’s name and location, the date and the total amount of the transaction, and other information provided by financial institutions or merchants when we act on their behalf.
- Product and service information, such as registration and payment information, and program-specific information, when you request products or services directly from us, or participate in marketing programs.
- Website, device and mobile app usage, and similar information collected via automated means, such as cookies and similar technologies.
- Job applications and related information when you apply for a job with us.
- Business contact information when you work for one of our business partners.
- Identity verification information, such as name, e-mail address, physical address, telephone number, and IP address.

For the purpose of this Global Privacy Notice, unless otherwise specified, “Personal Information” means any information relating to an identified or identifiable individual. We may obtain different types of Personal Information (including Sensitive Personal Information, as may be the case under applicable laws) relating to you in the situations described below.

Personal Information We Receive from Financial Institutions, Merchants, and Other Partners in Connection with Mastercard’s Products or Services

As a processor of payment transactions and provider of related services, we obtain a limited amount of information in connection with your payment transactions such as the personal account number, the merchant’s name and location, the date and the total amount of the transaction. Importantly, we generally do not need or collect the cardholder’s name or other contact information to process payment transactions.

In addition, for certain products and services, your financial institutions, the merchants where you make a transaction or other partners may provide us with more information about you, or we may collect it directly from you to provide you with those products and services on their behalf, support their business or perform processing activities on their behalf.

In the above situations, we may act on behalf of and under the instructions of financial institutions, merchants and other partners which act as data controllers. Unless otherwise authorized by law, we will process your Personal Information to process payment transactions or for the purposes agreed between Mastercard and the financial institutions, merchants and other partners. Please refer to their respective privacy policies for more information regarding the processing of your 
Personal Information.

Personal Information We Collect when Providing Mastercard’s Products and Services Directly to You

Mastercard may provide you directly with products and services such as marketing programs, rewards programs, eWallets, Open Banking solutions, prepaid services, location alert programs, and biometric authentication tools. To benefit from one or more of these products and services, you can submit information to us directly via various means including: (i) on our websites and digital assets, (ii) in response to marketing or other communications, (iii) by signing up for a Mastercard product or service, or (iv) through your participation in an offer, program or promotion. We may also obtain Personal Information about you through your use of our products or services, from companies that use or facilitate our products or services, from publicly available sources, or from third party partners. Your Personal Information may also be passed on to us by your financial institution, merchant or other business partners.

Below is an overview of the types of Personal Information we may collect in relation to programs we offer directly to you. Each program differs, so where applicable, please refer to the relevant program-specific privacy notice for more information on the use of your Personal Information for that specific program.
- Registration and payment information: We may collect identifiers and your contact information (such as name, email address, telephone number, billing or shipping address), authentication information (e.g., username and password), age, date of birth, gender and family status, military and veteran status, language preferences, payment details, personal account number, commercial information, such as merchant’s name and location, date and total amount of the transactions, card expiration date and card verification code.
- Information we process to provide you with the program: We may collect different types of Personal Information depending on the program. For example, programs designed to offer you location-based services will typically require the collection of your address or geolocation data. Programs within our Open Banking solutions may require the collection of your financial account information. Similarly, programs designed to allow you to authenticate for example, via facial or fingerprint recognition may require the processing of your photograph and/or biometric information. All these programs are voluntary, and your Personal Information is only collected if you subscribe to such programs.
- Other information you choose to provide: You may choose to provide other information, such as different types of content (e.g., photographs, articles, comments), contact information of friends or other people you would like us to contact, content you make available through social media accounts or memberships with third parties, or any other information you want to share with us, for example when you contact customer service.

You may be subject to obligations under applicable laws, such as the obligation to provide complete and accurate Personal Information when consenting to the processing of your Personal Information.

In addition, we may collect or use Personal Information for fraud prevention and monitoring, risk management, dispute resolution and other related purposes. Such information may include identifiers, commercial information, and Internet or other electronic network activity information, such as the personal account number, merchant’s name and location, date and total amount of the transactions, IP address, fraud score, location data, merchant details, items purchased and information about the dispute. When we provide cryptocurrency and blockchain intelligence solutions, we may also collect and process information gathered from the blockchain, including blockchain addresses and other cryptocurrency transaction details. 

Personal Information We Obtain from Your Interaction with Mastercard’s Ads, Websites, Apps or Other Digital Assets

We, our service providers and partners may collect certain information about you via automated means such as Internet or other electronic network activity information, cookies, and web beacons when you interact with our ads, mobile apps, or visit our websites, pages or other digital assets. The Internet and/or Device Information we collect in this manner may include: IP address, browser type, operating system, mobile device identifier, geographical area, referring URLs and information on actions taken or interaction with our digital assets. A “cookie” is a text file placed on a computer’s hard drive by a web server. A “web beacon,” also known as an Internet tag, pixel tag or clear GIF, is a technology that helps us identify when content has been accessed or visited.

We use this information to improve our online products and services by assessing how many users access or use our online products and services, which content, products and features of our online products and services most interest our visitors, what types of offers our customers like to see and how our online products and services perform from a technical point of view. For instance, we may use third-party web analytics services on our websites and mobile apps, such as those of Adobe Analytics. The analytics providers that administer these services use technologies such as cookies and web beacons to help us analyze how visitors use our websites and apps.

We, our service providers and partners may also collect information about you in connection with our marketing activities, including offers, sweepstakes, contests and promotions. The information collected for these purposes may include identifiers and your contact information (e.g., name, postal address, email address, telephone number), electronic identification data (e.g., username, password, security questions, IP address), and data collected in the context of online marketing programs, including commercial information, Internet or other electronic network activity information, geolocation data, and inferences drawn from Personal Information (e.g., personal characteristics, life habits, consumption habits, interests, location data, and voice and image recordings).

We, our service providers and partners may also collect information about you to provide you with content and advertising tailored to your individual interests based on inferences drawn from Personal Information. The information collected for these purposes may include Internet or other electronic network activity information, such as details about things like the particular pages or ads you view on our websites and apps and the actions you take on our websites and apps.
We, our service providers and partners may collect certain information about you via automated means such as, social media tools, widgets or plug-ins to connect you to your social media accounts. These features may allow you to sign in through your social media account, share a link or post directly to your social media account. When you visit a website that contains such tools or plugins, the social media or other service provider may learn of your visit. However, your interactions with these tools are governed by the privacy policies of the corresponding social media platforms. As we do not control these third-parties’ data handling practices, we recommend that you review their privacy policies, terms of use, and license agreements (if any).

In addition, some of our online products and services include advanced fraud prevention technology using behavioral-based data or biometric information, such as keystroke timing, device accelerometer, scroll position and mouse-location.

Where required under applicable law, we obtain your consent prior to using the above automated means, and prior to sending you marketing communications, tailored content and advertising.
""".trimIndent()
