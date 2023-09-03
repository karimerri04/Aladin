import 'package:aladin_driver_flutter/components/button/button_facebook_google.dart';
import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class ForgotPasswordScreen extends StatefulWidget {
  @override
  _ForgotPasswordState createState() => _ForgotPasswordState();
}

class _ForgotPasswordState extends State<ForgotPasswordScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Forgot password'),
      ),
      backgroundColor: kColorBlue,
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              //crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Padding(
                  padding: EdgeInsets.fromLTRB(20.0, 20.0, 20.0, 5.0),
                  child: Card(
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(18.0)),
                    elevation: kElevation,
                    color: kColorWhite,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: <Widget>[
                        SizedBox(height: 30.0),
                        CircularCardWidget(
                          image: Icon(
                            Icons.email,
                            size: 60.0,
                            color: kColorBlue,
                          ),
                          onPressed: () {},
                        ),
                        SizedBox(height: 30.0),
                        Center(
                          child: Padding(
                            padding: EdgeInsets.symmetric(horizontal: 20.0),
                            child: Text(
                              'Enter the email address associated with you account',
                              textAlign: TextAlign.center,
                              style: TextStyle(
                                  fontSize: kTextTitle,
                                  fontWeight: FontWeight.bold),
                            ),
                          ),
                        ),
                        Center(
                          child: Padding(
                            padding: EdgeInsets.symmetric(
                                horizontal: 20.0, vertical: 15.0),
                            child: Text(
                              'We will email you a code to reset your password',
                              textAlign: TextAlign.center,
                              style: TextStyle(
                                  fontSize: kTextTitle, color: Colors.grey),
                            ),
                          ),
                        ),
                        SizedBox(height: 10.0),
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: 'Enter your email',
                            keyboardType: TextInputType.emailAddress,
                            obscureText: false,
                            prefixIcon: Icon(Icons.email,
                                color: Colors.lightBlueAccent),
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        SizedBox(height: 5.0),
                        Padding(
                          padding: const EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {
                              Navigator.pushNamed(
                                  context, '/verification_code_screen');
                            },
                            text: 'SEND',
                            color: kColorBlue,
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
