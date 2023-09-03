import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class OpeningScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kColorBlue,
      body: Container(
        constraints: BoxConstraints.expand(),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          //crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Expanded(
              flex: 12,
              child: Center(
                child: Text(
                  "Aladin \nDriver",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    color: kColorWhite,
                    fontWeight: FontWeight.w700,
                    fontFamily: 'Roboto',
                    fontSize: 60.0,
                  ),
                ),
              ),
            ),
            Expanded(
              flex: 1,
              child: GestureDetector(
                onTap: () {
                  Navigator.pushNamed(context, '/location_screen');
                },
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text(
                      'Get started',
                      style: TextStyle(
                          color: kColorWhite,
                          fontSize: 30.0,
                          fontWeight: FontWeight.w600),
                    ),
                    Icon(
                      Icons.arrow_forward,
                      color: kColorWhite,
                      size: 30.0,
                    ),
                  ],
                ),
              ),
            ),
            Expanded(
              flex: 2,
              child: Center(
                child: GestureDetector(
                  onTap: () {
                    Navigator.pushNamed(context, '/login_screen');
                  },
                  child: RichText(
                    text: TextSpan(
                        text: 'Already have an account?',
                        style:
                            TextStyle(color: kColorWhite, fontSize: kTextTitle),
                        children: <TextSpan>[
                          TextSpan(
                            text: ' Login',
                            style: TextStyle(fontWeight: FontWeight.w700),
                          )
                        ]),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
