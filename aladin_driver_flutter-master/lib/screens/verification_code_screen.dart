import 'package:aladin_driver_flutter/components/button/button_facebook_google.dart';
import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class VerificationCodeScreen extends StatefulWidget {
  @override
  _VerificationCodeState createState() => _VerificationCodeState();
}

class _VerificationCodeState extends State<VerificationCodeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Verification code'),
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
                            Icons.lock,
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
                              'Enter the verification code we just you to your email address',
                              textAlign: TextAlign.center,
                              style: TextStyle(
                                  fontSize: kTextTitle,
                                  fontWeight: FontWeight.bold),
                            ),
                          ),
                        ),
                        SizedBox(height: 30.0),
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: '4 digits code',
                            keyboardType: TextInputType.number,
                            obscureText: false,
                            maxLength: 4,
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {
                              Navigator.pushNamed(
                                  context, '/create_new_password_screen');
                            },
                            text: 'CONFIRM',
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
                          text: 'Didn\'t receive code?',
                          style: TextStyle(
                              color: kColorWhite, fontSize: kTextLinks),
                          children: <TextSpan>[
                            TextSpan(
                              text: ' Resend',
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
