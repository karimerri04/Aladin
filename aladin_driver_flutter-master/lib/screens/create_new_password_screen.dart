import 'package:aladin_driver_flutter/components/button/button_facebook_google.dart';
import 'package:aladin_driver_flutter/components/button/button_principal.dart';
import 'package:aladin_driver_flutter/components/textField/textField_input_principal.dart';
import 'package:aladin_driver_flutter/values/colors.dart';
import 'package:aladin_driver_flutter/values/dimens.dart';
import 'package:flutter/material.dart';

class CreateNewPasswordScreen extends StatefulWidget {
  @override
  _CreateNewPasswordState createState() => _CreateNewPasswordState();
}

class _CreateNewPasswordState extends State<CreateNewPasswordScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: kColorBlue,
        title: Text('Create new password'),
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
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: 'Enter new password',
                            keyboardType: TextInputType.visiblePassword,
                            obscureText: true,
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        Padding(
                          padding: EdgeInsets.symmetric(
                              horizontal: 15.0, vertical: 8.0),
                          child: TextInput(
                            hintText: 'Confirm new password',
                            keyboardType: TextInputType.visiblePassword,
                            obscureText: true,
                            colorBorder: kColorBlue,
                            validator: (value) {},
                            onChanged: (value) {},
                          ),
                        ),
                        SizedBox(height: 5.0),
                        Padding(
                          padding: const EdgeInsets.all(15.0),
                          child: ButtonPrincipal(
                            onPressed: () {},
                            text: 'CONFIRM',
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
