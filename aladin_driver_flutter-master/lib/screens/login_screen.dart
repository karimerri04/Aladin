import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Login'),
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
                      borderRadius: BorderRadius.circular(18.0),
                    ),
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
                            hintText: 'Email',
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
                            hintText: 'Password',
                            keyboardType: TextInputType.visiblePassword,
                            obscureText: true,
                            prefixIcon:
                                Icon(Icons.lock, color: Colors.lightBlueAccent),
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        Padding(
                          padding: EdgeInsets.only(right: 15.0),
                          child: GestureDetector(
                            child: Text(
                              'Forgot password?',
                              style:
                                  TextStyle(fontSize: 15.0, color: kColorBlue),
                              textAlign: TextAlign.end,
                            ),
                            onTap: () {
                              Navigator.pushNamed(
                                  context, '/forgot_password_screen');
                            },
                          ),
                        ),
                        SizedBox(height: 10.0),
                        Padding(
                          padding: const EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {},
                            text: 'login',
                            color: kColorBlue,
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
                Center(
                  child: GestureDetector(
                    onTap: () {
                      Navigator.pushNamed(context, '/location_screen');
                    },
                    child: RichText(
                      text: TextSpan(
                          text: 'Don\'t have an account?',
                          style: TextStyle(
                              color: kColorWhite, fontSize: kTextLinks),
                          children: <TextSpan>[
                            TextSpan(
                              text: ' Create an account',
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
