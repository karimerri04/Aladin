import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class TermsOfUseScreen extends StatefulWidget {
  @override
  _TermsOfUseScreenState createState() => _TermsOfUseScreenState();
}

class _TermsOfUseScreenState extends State<TermsOfUseScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Terms of use'),
      ),
      backgroundColor: kColorBlue,
      body: SafeArea(
        child: Container(
          color: kColorWhite,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            //crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Expanded(
                child: Container(
                  child: Text(
                    "",
                    style: TextStyle(fontSize: kTextParagraph),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
