import 'package:aladin_driver_flutter/screens/account_screen.dart';
import 'package:aladin_driver_flutter/screens/bottom_navigation_screen.dart';
import 'package:aladin_driver_flutter/screens/create_new_password_screen.dart';
import 'package:aladin_driver_flutter/screens/forgot_password_screen.dart';
import 'package:aladin_driver_flutter/screens/location_screen.dart';
import 'package:aladin_driver_flutter/screens/login_screen.dart';
import 'package:aladin_driver_flutter/screens/opening_screen.dart';
import 'package:aladin_driver_flutter/screens/signup_screen.dart';
import 'package:aladin_driver_flutter/screens/splash_screen.dart';
import 'package:aladin_driver_flutter/screens/tell_us_about_you_screen.dart';
import 'package:aladin_driver_flutter/screens/terms_of_use_screen.dart';
import 'package:aladin_driver_flutter/screens/verification_code_screen.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';

void main() => runApp(AladinDriver());

class AladinDriver extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(appBarTheme: AppBarTheme(color: kColorBlue)),
      initialRoute: '/',
      routes: {
        '/': (context) => FirstScreen(),
        '/opening_screen': (context) => OpeningScreen(),
        '/login_screen': (context) => LoginScreen(),
        '/forgot_password_screen': (context) => ForgotPasswordScreen(),
        '/verification_code_screen': (context) => VerificationCodeScreen(),
        '/create_new_password_screen': (context) => CreateNewPasswordScreen(),
        '/location_screen': (context) => LocationScreen(),
        '/signup_screen': (context) => SignUpScreen(),
        '/tell_us_about_you_screen': (context) => TellUsAboutYouScreen(),
        '/terms_of_use_screen': (context) => TermsOfUseScreen(),
        '/bottom_navigation_screen': (context) => BottomNavigationScreen(),
        '/account_screen': (context) => AccountScreen(),
      },
    );
  }
}
