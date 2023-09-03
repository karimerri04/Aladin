import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class SignUpScreen extends StatefulWidget {
  @override
  _SignUpScreenState createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Sign Up'),
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
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: 'Create password',
                            keyboardType: TextInputType.visiblePassword,
                            obscureText: true,
                            prefixIcon:
                                Icon(Icons.lock, color: Colors.lightBlueAccent),
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        SizedBox(height: 10.0),
                        Padding(
                          padding: EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {
                              Navigator.pushNamed(
                                  context, '/tell_us_about_you_screen');
                            },
                            text: 'CONTINUE',
                            color: kColorBlue,
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
                Center(
                  child: GestureDetector(
                    onTap: () {},
                    child: RichText(
                      text: TextSpan(
                          text: 'Sign up later,',
                          style: TextStyle(
                              color: kColorWhite, fontSize: kTextLinks),
                          children: <TextSpan>[
                            TextSpan(
                              text: ' continue as a guest',
                              style: TextStyle(fontWeight: FontWeight.w700),
                            )
                          ]),
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
