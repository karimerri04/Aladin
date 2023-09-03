import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:flutter/material.dart';
import 'package:splashscreen/splashscreen.dart';

import 'opening_screen.dart';

class FirstScreen extends StatefulWidget {
  @override
  _FirstScreenState createState() => _FirstScreenState();
}

class _FirstScreenState extends State<FirstScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SplashScreen(
      backgroundColor: kColorBlue,
      seconds: 2,
      loaderColor: kColorBlue,
      navigateAfterSeconds: OpeningScreen(),
      title: Text(
        "Aladin",
        textAlign: TextAlign.center,
        style: TextStyle(
          color: kColorWhite,
          fontFamily: "SF Pro Rounded",
          fontWeight: FontWeight.w700,
          fontSize: 60,
        ),
      ),
    ));
  }
}
